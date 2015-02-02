package cn.wh.anyst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.anyst.entity.Product;
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
	public String giftListEdit(@RequestParam("productCode") String code,
			Model model) {
		
		return "inc/inc_gift_list_add";
	}
	
	@RequestMapping("/inc_gift_list_add_infos")
	public String giftListAddInfos(Model model) {
		return "inc/inc_gift_list_add_infos";
	}
	
	@RequestMapping("/inc_gift_list_add_imgs")
	public String giftListAddImgs(Model model) {
		return "inc/inc_gift_list_add_imgs";
	}
	@RequestMapping("/inc_gift_list_edit_infos")
	public String giftListEditInfos(@RequestParam("productCode") String code,
			@RequestParam("productName") String name,
			@RequestParam("productDescription") String description,
			Model model) {
		
		return "inc/inc_gift_list_add_infos";
	}
	
	@RequestMapping("/inc_gift_list_edit_imgs")
	public String giftListEditImgs(@RequestParam("productCode") String code,
			@RequestParam("productImgUrls") String urls,
			Model model) {
		
		return "inc/inc_gift_list_add_imgs";
	}
}
