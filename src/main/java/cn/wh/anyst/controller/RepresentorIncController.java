package cn.wh.anyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 代表页面Controller
 */
@Controller
@RequestMapping("/inc/repr")
public class RepresentorIncController {

	@RequestMapping("/inc_repr_list")
	public String reprlist() {
		return "inc/inc_repr_list";
	}
	
	@RequestMapping("/inc_repr_list_add")
	public String reprListAdd() {
		return "inc/inc_repr_list_add";
	}
	
	@RequestMapping("/inc_repr_list_edit")
	public String reprListEdit(@RequestParam("productCode") String code,
			Model model) {
		
		return "inc/inc_repr_list_add";
	}
	
	@RequestMapping("/inc_repr_list_add_infos")
	public String reprListAddInfos(Model model) {
		return "inc/inc_repr_list_add_infos";
	}
	
	@RequestMapping("/inc_repr_list_edit_infos")
	public String reprListEditInfos(@RequestParam("productCode") String code,
			@RequestParam("productName") String name,
			@RequestParam("productDescription") String description,
			Model model) {
		
		return "inc/inc_repr_list_add_infos";
	}
	
	@RequestMapping("/inc_repr_list_relation")
	public String reprListRelation(Model model) {
		return "inc/inc_repr_list_relation";
	}
	
	@RequestMapping("/inc_repr_list_relation_custList")
	public String reprListRelationCustList(Model model) {
		
		return "inc/inc_repr_list_relation_custList";
	}
	
	@RequestMapping("/inc_repr_list_relation_prodList")
	public String reprListRelationProdList(Model model) {
		
		return "inc/inc_repr_list_relation_prodList";
	}
}
