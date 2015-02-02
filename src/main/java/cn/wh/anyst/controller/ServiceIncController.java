package cn.wh.anyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 客服页面Controller
 */
@Controller
@RequestMapping("/inc/serv")
public class ServiceIncController {
	@RequestMapping("/inc_serv_list")
	public String servlist() {
		return "inc/inc_serv_list";
	}
	
	@RequestMapping("/inc_serv_list_add")
	public String servListAdd() {
		return "inc/inc_serv_list_add";
	}
	@RequestMapping("/inc_serv_list_add_infos")
	public String servListAddInfos() {
		return "inc/inc_serv_list_add_infos";
	}
}
