package cn.wh.anyst.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.anyst.entity.Gift;
import cn.wh.anyst.service.GiftService;

/*
 * 礼物页面Controller
 */
@Controller
@RequestMapping("/inc/gift")
public class GiftIncController {
	
	@Autowired
	private GiftService giftService;
	
	@RequestMapping("/inc_gift_list")
	public String giftlist() {
		return "inc/inc_gift_list";
	}
	
	@RequestMapping("/inc_gift_list_add")
	public String giftListAdd() {
		return "inc/inc_gift_list_add";
	}
	
	@RequestMapping("/inc_gift_list_edit")
	public String giftListEdit(
			@RequestParam("giftCode") String code,								//礼物编码
			Model model) {
		System.out.println("gift code =" + code);
		Gift gift = giftService.queryGiftByCode(code);
		if (gift != null) {
			System.out.println("gift code find =" + code);
			model.addAttribute("giftBean", gift);
		}
		return "inc/inc_gift_list_add";
	}
	
	@RequestMapping("/inc_gift_list_add_infos")
	public String giftListAddInfos() {
		return "inc/inc_gift_list_add_infos";
	}
	
	@RequestMapping("/inc_gift_list_add_imgs")
	public String giftListAddImgs() {
		return "inc/inc_gift_list_add_imgs";
	}
	@RequestMapping("/inc_gift_list_edit_infos")
	public String giftListEditInfos(
			@RequestParam("giftCode") String code,								//礼物编码
			@RequestParam("giftName") String name,								//礼物名称
			@RequestParam("giftDescription") String description,				//礼物说明
			@RequestParam("productCode") String productCode,					//礼物对应的产品编码
			@RequestParam("giftGroup") Long groupId,							//礼物对应分组ID 
			@RequestParam("giftPrice") int price,								//礼物的市场价格
			@RequestParam("giftCost") int cost,									//礼物的成本价格
			@RequestParam("exchangeValue") int value,							//礼物兑换个数
			Model model) throws UnsupportedEncodingException {
		Gift gift = new Gift();
		gift.setCode(code);
		gift.setGiftName(new String(name.getBytes("ISO-8859-1")));
		gift.setGiftDiscribe(new String(description.getBytes("ISO-8859-1")));
		gift.setExchangeValue(value);
		gift.setGiftCost(cost);
		gift.setGiftPrice(price);
		gift.setProduct(productCode);
		gift.setGiftGroup(groupId);
		model.addAttribute("giftBean", gift);
		return "inc/inc_gift_list_add_infos";
	}
	
	@RequestMapping("/inc_gift_list_edit_imgs")
	public String giftListEditImgs(@RequestParam("productCode") String code,
			@RequestParam("productImgUrls") String urls,
			Model model) {
		return "inc/inc_gift_list_add_imgs";
	}
}
