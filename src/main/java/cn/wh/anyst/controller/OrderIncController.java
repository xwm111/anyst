package cn.wh.anyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 订单页面Controller
 */
@Controller
@RequestMapping("/inc/orde")
public class OrderIncController {
	@RequestMapping("/inc_orde_list")
	public String ordelist() {
		return "inc/inc_orde_list";
	}
}
