package cn.wh.anyst.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.anyst.entity.Product;
import cn.wh.anyst.service.ProductService;

/*
 * 产品页面Controller
 */
@Controller
@RequestMapping("/inc/product")
public class ProductIncController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/inc_prod_list")
	public String prodlist() {
		return "inc/inc_prod_list";
	}
	
	@RequestMapping("/inc_prod_list_add")
	public String prodListAdd() {
		return "inc/inc_prod_list_add";
	}
	
	@RequestMapping("/inc_prod_list_edit")
	public String prodListEdit(@RequestParam("productCode") String code,
			Model model) {
		Product product = productService.findByCode(code);
		if (product != null) {
			model.addAttribute("productBean", product);
		}
		return "inc/inc_prod_list_add";
	}
	
	@RequestMapping("/inc_prod_list_add_infos")
	public String prodListAddInfos(Model model) {
		return "inc/inc_prod_list_add_infos";
	}
	
	@RequestMapping("/inc_prod_list_add_imgs")
	public String prodListAddImgs(Model model) {
		return "inc/inc_prod_list_add_imgs";
	}
	@RequestMapping("/inc_prod_list_edit_infos")
	public String prodListEditInfos(@RequestParam("productCode") String code,
			@RequestParam("productName") String name,
			@RequestParam("productDescription") String description,
			Model model) throws UnsupportedEncodingException {
		System.out.println("productDescription:" + description);
		Product product = new Product();
		product.setCode(new String(code.getBytes("ISO-8859-1")));
		product.setName(new String(name.getBytes("ISO-8859-1")));
		product.setDescription(new String(description.getBytes("ISO-8859-1")));
		model.addAttribute("productBean", product);
		return "inc/inc_prod_list_add_infos";
	}
	
	@RequestMapping("/inc_prod_list_edit_imgs")
	public String prodListEditImgs(@RequestParam("productCode") String code,
			@RequestParam("productImgUrls") String urls,
			Model model) {
		Product product = new Product();
		product.setCode(code);
		product.setProductImgUrls(urls);
		model.addAttribute("productBean", product);
		return "inc/inc_prod_list_add_imgs";
	}
}
