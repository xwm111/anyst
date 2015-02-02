package cn.wh.anyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 结算页面Controller
 */
@Controller
@RequestMapping("/inc/sett")
public class SettlementIncController {
	
	@RequestMapping("/inc_sett_list")
	public String settlist() {
		return "inc/inc_sett_list";
	}
}
