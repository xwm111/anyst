package cn.wh.anyst.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wh.anyst.entity.GiftGroup;
import cn.wh.anyst.entity.Product;
import cn.wh.anyst.service.BasicService;
import cn.wh.anyst.service.ExchangeHistoryService;
import cn.wh.anyst.service.GiftService;
import cn.wh.anyst.service.ProductService;
import cn.wh.anyst.util.WxUserInfoUpdateEventHandler;
import cn.wh.anyst.view.GiftView;

/*
 * 微信controller
 * 处理微信公众号发来的消息
 */
@Controller
@RequestMapping("/")
public class weixinController {
	private static Logger logger = LoggerFactory.getLogger(weixinController.class);

	@Autowired
	private WxMpServiceImpl wxService;

	@Autowired
	private BasicService basicService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private WxMpMessageHandler contenthandler;
	
	@Autowired
	private GiftService giftService;
	
	@Autowired
	private ExchangeHistoryService exchangeHistoryService;
	
	@RequestMapping("anystwx")
	@ResponseBody
	public String index(@RequestBody String code,@RequestParam(value = "signature", required = false) String signature, @RequestParam(value = "nonce", required = false) String nonce,
			@RequestParam(value = "timestamp", required = false) String timestamp, @RequestParam(value = "echostr", required = false) String echostr)
			throws NoSuchAlgorithmException {
		logger.debug(String.format("Incoming params are signature:---%s---nonce:---%s---timestamp:---%s---echostr:---%s---", signature, nonce, timestamp,
				echostr));
		logger.debug(code);
		WxMpXmlMessage message =WxMpXmlMessage.fromXml(code);
		logger.debug("from user name is :"+message.getFromUserName());
		if (wxService.checkSignature(timestamp, nonce, signature)) {
			WxMpMessageRouter router = new WxMpMessageRouter(wxService);
			WxMpMessageHandler eventhandler = new WxUserInfoUpdateEventHandler();
			router.rule().
			async(true).
			msgType(WxConsts.XML_MSG_EVENT)
			.eventKey("updateUserInfo")
			.rContent("")
			.handler(eventhandler)
			.next()
			.rule()
			.async(true)
			.msgType(WxConsts.XML_MSG_TEXT)
			.handler(contenthandler)
			.end();
			router.route(message);
			return echostr;
		} else {
			return "message is not from wx";
		}
	}

	/**
	 * 根据产品ID初始化
	 * 
	 * @param id
	 *            产品ID
	 * @return
	 */
	@RequestMapping("mbproduct/{code}")
	public String initGift(@PathVariable("code") String code, Model model, HttpSession session) {
		session.setAttribute("pcode", code);// 在session中保存产品code
		Product p = productService.findByCode(code);
		List<GiftGroup> gglist = basicService.findGiftGroupByProductCode(code);
		model.addAttribute("p", p);
		model.addAttribute("gglist", gglist);
		model.addAttribute("pcode", code);
		logger.debug("手机访问礼品页查询页,礼品名称---" + p.getName());
		return "wx/gift";
	}

	/**
	 * 根据产品code,贴花数量，礼品分组查询 礼品列表
	 * 
	 * @param flowerrange
	 * @param giftgroup
	 * @param pcode
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "mbsearchgift", method = RequestMethod.POST)
	public String giftList(@RequestParam("flowerrange") String flowerrange, @RequestParam("giftgroup") String giftgroup, @RequestParam("pcode") String pcode,
			Model model) {
		logger.debug("手机访问--查询礼品,礼品分类---" + giftgroup + "    贴花范围：" + flowerrange + "    产品编码:" + pcode);
		model.addAttribute("giftgroup", giftgroup);
		model.addAttribute("flowerrange", flowerrange);
		model.addAttribute("pcode", pcode);
		return "wx/gift_list";
	}

	/**
	 * 根据礼品ID查询礼品详情
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "mbgift/{id}", method = RequestMethod.GET)
	public String giftDetail(@PathVariable("id") String id, Model model) {
		logger.debug("手机访问--查询礼品详情---礼品ID:" + id);
		model.addAttribute("id", id);
		GiftView view =  giftService.findGiftById(id);
		model.addAttribute("gift",view);
		return "wx/gift_list_view";
	}

	/**
	 * 根据礼品id 和 数量 购买礼品
	 * 
	 * @param id
	 * @param number
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "mbbuygift", method = RequestMethod.POST)
	public String buyGift(@RequestParam("id") String id, @RequestParam("number") int number, HttpSession session, Model model) {
		logger.debug("手机访问--礼品购买---礼品ID:" + id + "   礼品数量:" + number);
		exchangeHistoryService.orderGift(id);
		model.addAttribute("pcode", session.getAttribute("pcode"));
		return "wx/gift_list_buy";
	}

}
