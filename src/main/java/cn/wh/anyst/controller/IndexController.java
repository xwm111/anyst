package cn.wh.anyst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 主页Controller
 */
@Controller
@RequestMapping("/")
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	/*
	 * 主页
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	/*
	 * 产品页面
	 */
	@RequestMapping("/prod")
	public String prod() {
		return "prod";
	}
	
	/*
	 * 礼物页面
	 */
	@RequestMapping("/gift")
	public String gift() {
		return "gift";
	}
	
	/*
	 * 客户页面
	 */
	@RequestMapping("/cust")
	public String cust() {
		return "cust";
	}
	
	/*
	 * 供应商页面
	 */
	@RequestMapping("/dist")
	public String dist() {
		return "dist";
	}
	
	/*
	 * 代表页面
	 */
	@RequestMapping("/repr")
	public String repr() {
		return "repr";
	}
	
	/*
	 * 基础数据页面
	 */
	@RequestMapping("/basi")
	public String basi() {
		return "basi";
	}
	
	/*
	 * 结算页面
	 */
	@RequestMapping("/sett")
	public String sett() {
		return "sett";
	}
	
	/*
	 * 订单页面
	 */
	@RequestMapping("/orde")
	public String orde() {
		return "orde";
	}
	
	/*
	 * 客服页面
	 */
	@RequestMapping("/serv")
	public String serv() {
		return "serv";
	}
	
	/*
	 * 日志页面
	 */
	@RequestMapping("/logm")
	public String logm() {
		return "logm";
	}
}
