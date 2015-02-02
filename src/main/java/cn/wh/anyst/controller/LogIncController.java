package cn.wh.anyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 日志页面Controller
 */
@Controller
@RequestMapping("/inc/logm/")
public class LogIncController {
	@RequestMapping("/inc_logm_list")
	public String settlist() {
		return "inc/inc_logm_list";
	}
}
