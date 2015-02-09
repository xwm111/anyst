package cn.wh.anyst.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.anyst.entity.Supplier;
import cn.wh.anyst.service.SupplierService;

/*
 * 经销商页面Controller
 */
@Controller
@RequestMapping("/inc/dist")
public class SupplierIncController {
	
	@Autowired
	private SupplierService supplierService;

	@RequestMapping("/inc_dist_list")
	public String giftlist() {
		return "inc/inc_dist_list";
	}
	
	@RequestMapping("/inc_dist_list_add")
	public String giftListAdd() {
		return "inc/inc_dist_list_add";
	}
	
	@RequestMapping("/inc_dist_list_edit")
	public String giftListEdit(@RequestParam("supplierId") Long id,					//分销商ID
			Model model,
			ServletRequest request) {
		Supplier supplier = supplierService.querySupplier(id);
		if (supplier != null) {
			model.addAttribute("supplierBean", supplier);
		}
		return "inc/inc_dist_list_add";
	}
	
	@RequestMapping("/inc_dist_list_add_infos")
	public String giftListAddInfos() {
		return "inc/inc_dist_list_add_infos";
	}
	
	@RequestMapping("/inc_dist_list_edit_infos")
	public String giftListEditInfos(
			@RequestParam(value = "supplierId") Long id,							//分销商ID
			@RequestParam(value = "supplierName") String name,						//分销商名称
			@RequestParam(value = "supplierEmail") String email,					//分销商邮件地址
			@RequestParam(value = "supplierPhone") String phone,					//分销商电话
			@RequestParam(value = "supplierDescription") String description,		//分销商说明
			Model model,
			ServletRequest request) throws UnsupportedEncodingException {
			Supplier supplier = new Supplier();
			supplier.setId(id);
			supplier.setName(new String(name.getBytes("ISO-8859-1")));
			supplier.setDescription(new String(description.getBytes("ISO-8859-1")));
			supplier.setEmail(email);
			supplier.setPhone(phone);
			model.addAttribute("supplierBean", supplier);
		return "inc/inc_dist_list_add_infos";
	}
}
