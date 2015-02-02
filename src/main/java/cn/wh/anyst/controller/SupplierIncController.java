package cn.wh.anyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 经销商页面Controller
 */
@Controller
@RequestMapping("/inc/dist")
public class SupplierIncController {

	@RequestMapping("/inc_dist_list")
	public String giftlist() {
		return "inc/inc_dist_list";
	}
	
	@RequestMapping("/inc_dist_list_add")
	public String giftListAdd() {
		return "inc/inc_dist_list_add";
	}
	
	@RequestMapping("/inc_dist_list_edit")
	public String giftListEdit(@RequestParam("productCode") String code,
			Model model) {
		
		return "inc/inc_dist_list_add";
	}
	
	@RequestMapping("/inc_dist_list_add_infos")
	public String giftListAddInfos(Model model) {
		return "inc/inc_dist_list_add_infos";
	}
	
	@RequestMapping("/inc_dist_list_edit_infos")
	public String giftListEditInfos(@RequestParam("productCode") String code,
			@RequestParam("productName") String name,
			@RequestParam("productDescription") String description,
			Model model) {
		
		return "inc/inc_dist_list_add_infos";
	}
}
