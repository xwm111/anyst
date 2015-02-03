package cn.wh.anyst.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 微信controller
 * 处理微信公众号发来的消息
 */
@Controller
@RequestMapping("/")
public class weixinController {
	private static Logger logger = LoggerFactory.getLogger(weixinController.class);
	
	@RequestMapping("anystwx")
	@ResponseBody
	public Map<String, String> index() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "xwm");
		return map;
	}
	
}
