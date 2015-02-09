package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.controller.WeixinController;
import cn.wh.anyst.entity.Gift;
import cn.wh.anyst.service.GiftService;

/*
 * 礼物restful接口
 */
@RestController
@RequestMapping(value = "/api/v1/gift")
public class GiftRest {
	private static Logger logger = LoggerFactory.getLogger(GiftRest.class);
	@Autowired
	private GiftService giftService;

	// 列出礼品信息并分页
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Gift> list(@RequestParam(value = "giftCode", defaultValue = "") String code, // 礼物编码
			@RequestParam(value = "giftName", defaultValue = "") String name, // 礼物名称
			@RequestParam(value = "giftGroup", defaultValue = "-1") Long groupId, // 礼物分组ID
			@RequestParam(value = "giftStatus", defaultValue = "-1") int status, // 礼物状态
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, // 分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, // 每页数量
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, // 排序规则
			ServletRequest request) throws UnsupportedEncodingException {
		Page<Gift> giftPqge = giftService.listGift((name.equals("") ? null : new String(name.getBytes("ISO-8859-1"))), (code.equals("") ? null : code),
				groupId, status, pageNumber, pageSize);
		RestQueryResultModal<Gift> result = new RestQueryResultModal<Gift>(giftPqge.getTotalElements(), giftPqge.getContent());
		return result;
	}

	// 创建新礼品信息
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(@RequestParam("giftCode") String code, // 礼物编码
			@RequestParam("giftName") String name, // 礼物名称
			@RequestParam("giftDescription") String description, // 礼物说明
			@RequestParam("productCode") String productCode, // 礼物对应的产品编码
			@RequestParam("giftGroup") Long groupId, // 礼物对应分组ID
			@RequestParam("giftPrice") int price, // 礼物的市场价格
			@RequestParam("giftCost") int cost, // 礼物的成本价格
			@RequestParam(value = "giftStatus", defaultValue = "0") int status, // 礼物状态
																				// //礼物状态
			@RequestParam("exchangeValue") int value, // 礼物兑换个数
			ServletRequest request) {
		Gift gift = new Gift();
		gift.setCode(code);
		gift.setGiftName(name);
		gift.setGiftDiscribe(description);
		gift.setProduct(productCode);
		gift.setGiftGroup(groupId);
		gift.setGiftPrice(price);
		gift.setGiftCost(cost);
		gift.setStatus(status);
		gift.setExchangeValue(value);
		giftService.createGift(gift);
		return 1;
	}

	// 更新礼品信息
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(@RequestParam("giftCode") String code, // 礼物编码
			@RequestParam("giftName") String name, // 礼物名称
			@RequestParam("giftDescription") String description, // 礼物说明
			@RequestParam("productCode") String productCode, // 礼物对应的产品编码
			@RequestParam("giftGroup") Long groupId, // 礼物对应分组ID
			@RequestParam("giftPrice") int price, // 礼物的市场价格
			@RequestParam("giftCost") int cost, // 礼物的成本价格
			@RequestParam(value = "giftStatus", defaultValue = "0") int status, // 礼物状态
			@RequestParam("exchangeValue") int value, // 礼物兑换个数
			ServletRequest request) {
		Gift gift = giftService.queryGiftByCode(code);
		if (gift != null) {
			gift.setCode(code);
			gift.setGiftName(name);
			gift.setGiftDiscribe(description);
			gift.setProduct(productCode);
			gift.setGiftGroup(groupId);
			gift.setGiftPrice(price);
			gift.setGiftCost(cost);
			gift.setStatus(status);
			gift.setExchangeValue(value);
			giftService.createGift(gift);
			return 1;
		}
		return 0;
	}

	// 删除礼品信息
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(@RequestParam("giftCode") String code, // 礼物编码
			ServletRequest request) {
		giftService.deleteGiftByCode(code);
		return 1;
	}

	// 礼品上架
	@RequestMapping(value = "/shiftOn", method = RequestMethod.POST)
	public int shiftOn(@RequestParam("giftCode") String code, // 礼物编码
			ServletRequest request) {
		Gift gift = giftService.queryGiftByCode(code);
		if (gift != null) {
			gift.setStatus(1);
			giftService.createGift(gift);
			return 1;
		}
		return 0;
	}

	// 礼品下架
	@RequestMapping(value = "/shiftOff", method = RequestMethod.POST)
	public int shiftOff(@RequestParam("giftCode") String code, // 礼物编码
			ServletRequest request) {
		Gift gift = giftService.queryGiftByCode(code);
		if (gift != null) {
			gift.setStatus(0);
			giftService.createGift(gift);
			return 1;
		}
		return 0;
	}

	// 手机访问
	// 根据产品pcode,礼品分组giftgroup,贴花数量范围flowerrange 分页page查询礼品集合
	//贴花数量范围说明 flowerrange 0表示1-5，1表示 6-10 ，2表示 11-15 目前暂用这3个值
	@RequestMapping(value = "/mbquery", method = RequestMethod.GET)
	public RestQueryResultModal<Gift> mbliftquery(@RequestParam("pcode") String pcode, @RequestParam("giftgroup") String giftgroup,
			@RequestParam("flowerrange") String flowerrange,@RequestParam("page") int page) {
		//TODO  根据产品pcode,礼品分组giftgroup,贴花数量范围flowerrange 分页page查询礼品集合
		logger.debug("手机访问，查询礼品列表，查询参数 pcode:"+pcode+"  giftgroup:"+giftgroup+" flowerrange:"+flowerrange);
		//用户测试，使用了全部的gift 没管分页
		Page<Gift> giftPqge = giftService.listGift(null,null,-1l,-1,5,page);
		RestQueryResultModal<Gift> result = new RestQueryResultModal<Gift>(giftPqge.getTotalElements(), giftPqge.getContent());
		return result;
	}
}
