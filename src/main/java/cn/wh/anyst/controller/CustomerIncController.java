package cn.wh.anyst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.anyst.service.GiftService;

/*
 * 客户页面Controller
 */
@Controller
@RequestMapping("inc/cust")
public class CustomerIncController {
	
	@Autowired
	private GiftService giftService;
	
	@RequestMapping("/inc_cust_list")
	public String custlist() {
		return "inc/inc_cust_list";
	}
	
	@RequestMapping("/inc_cust_list_add")
	public String custListAdd() {
		return "inc/inc_cust_list_add";
	}
	
	@RequestMapping("/inc_cust_list_edit")
	public String custListEdit(@RequestParam("productCode") String code,
			Model model) {
		
		return "inc/inc_cust_list_add";
	}
	
	@RequestMapping("/inc_cust_list_add_infos")
	public String custListAddInfos(Model model) {
		return "inc/inc_cust_list_add_infos";
	}
	
	@RequestMapping("/inc_cust_list_edit_infos")
	public String custListEditInfos(@RequestParam("productCode") String code,
			@RequestParam("productName") String name,
			@RequestParam("productDescription") String description,
			Model model) {
		
		return "inc/inc_cust_list_add_infos";
	}
}
