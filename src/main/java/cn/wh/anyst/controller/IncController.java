package cn.wh.anyst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.anyst.entity.Product;
import cn.wh.anyst.service.ProductService;

/*
 * 主页框架页面Controller
 */
@Controller
@RequestMapping("/inc")
public class IncController {
	private static Logger logger = LoggerFactory.getLogger(IncController.class);
	
	@RequestMapping("/inc_header")
	public String header() {
		return "inc/inc_header";
	}
	
	@RequestMapping("/inc_footer")
	public String footer() {
		return "inc/inc_footer";
	}
	
	@RequestMapping("/inc_leftTabs")
	public String lefttabs() {
		return "inc/inc_leftTabs";
	}
}
