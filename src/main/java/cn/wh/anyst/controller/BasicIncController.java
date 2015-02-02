package cn.wh.anyst.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wh.anyst.entity.CustomerGroup;
import cn.wh.anyst.entity.Department;
import cn.wh.anyst.entity.GiftGroup;
import cn.wh.anyst.entity.Hospital;
import cn.wh.anyst.service.BasicService;

/*
 * 基础数据页面Controller
 */
@Controller
@RequestMapping("/inc/basi")
public class BasicIncController {
	
	@Autowired
	private BasicService basicService;
	
	@RequestMapping("/inc_group_list")
	public String basiGroupList() {
		return "inc/inc_group_list";
	}
	
	@RequestMapping("/inc_class_list")
	public String basiClassList() {
		return "inc/inc_class_list";
	}
	
	@RequestMapping("/inc_depar_list")
	public String basiDeparList() {
		return "inc/inc_depar_list";
	}
	
	@RequestMapping("/inc_flowe_list")
	public String basiFloweList() {
		return "inc/inc_flowe_list";
	}
	
	@RequestMapping("/inc_group_list_add")
	public String basiGroupListAdd() {
		return "inc/inc_group_list_add";
	}
	
	@RequestMapping("/inc_group_list_edit")
	public String basiGroupListEdit(
			@RequestParam(value = "customerGroupId") Long id,						//客户分组ID
			Model model,
			ServletRequest request) {
		CustomerGroup group = basicService.queryCustomerGroupById(id);
		if (group != null) {
			model.addAttribute("customerGroupBean", group);
			return "inc/inc_group_list_add";
		}
		return "inc/inc_group_list_add";
	}
	
	@RequestMapping("/inc_group_list_edit_infos")
	public String basiGroupListEditInfos(
			@RequestParam(value = "customerGroupId") Long id,						//客户分组ID
			@RequestParam(value = "customerGroupName") String name,					//客户分组名称
			@RequestParam(value = "customerGroupDescription") String description,	//客户分组描述
			Model model,
			ServletRequest request) throws UnsupportedEncodingException {
		
		CustomerGroup group = new CustomerGroup();
		group.setId(id);
		group.setName(new String(name.getBytes("ISO-8859-1")));
		group.setDescription(new String(description.getBytes("ISO-8859-1")));
		model.addAttribute("customerGroupBean", group);
		return "inc/inc_group_list_add_infos";
	}
	
	@RequestMapping("/inc_group_list_add_infos")
	public String basiGroupListAddInfos() {
		return "inc/inc_group_list_add_infos";
	}
	
	@RequestMapping("/inc_class_list_add")
	public String basiClassListAdd() {
		return "inc/inc_class_list_add";
	}
	
	@RequestMapping("/inc_class_list_edit")
	public String basiClassListEdit(
			@RequestParam(value = "giftGroupId") Long id,					//礼品分类ID
			Model model,
			ServletRequest request) {
		GiftGroup giftGroup = basicService.queryGiftGroupById(id);
		if (giftGroup != null) {
			model.addAttribute("giftGroupBean", giftGroup);
			return "inc/inc_class_list_add";
		}
		return "inc/inc_class_list_add";
	}
	
	@RequestMapping("/inc_class_list_edit_infos")
	public String basiClassListEditInfos(
			@RequestParam(value = "giftGroupId") Long id,						//礼品分类ID
			@RequestParam(value = "giftGroupName") String name,					//礼品分类名称
			@RequestParam(value = "giftGroupIsDisplay") int isDisplay,			//礼品分类是否显示
			@RequestParam(value = "giftGroupOrder") int order,					//礼品分类显示排序
			@RequestParam(value = "giftGroupDescription") String description,	//客户分组描述
			Model model,
			ServletRequest request) throws UnsupportedEncodingException {
		GiftGroup giftGroup = new GiftGroup();
		giftGroup.setId(id);
		giftGroup.setIsDisplay(isDisplay);
		giftGroup.setDisplayOrder(order);
		giftGroup.setName(new String(name.getBytes("ISO-8859-1")));
		giftGroup.setDescription(new String(description.getBytes("ISO-8859-1")));
		model.addAttribute("giftGroupBean", giftGroup);
		return "inc/inc_class_list_add_infos";
	}
	
	@RequestMapping("/inc_depar_list_add_hospital_infos")
	public String basiClassListAddHospitalInfos() {
		return "inc/inc_depar_list_add_hospital_infos";
	}
	
	@RequestMapping("/inc_depar_list_add_department_infos")
	public String basiDeparListAddDepartmentInfos(
			@RequestParam(value = "hospitalId") Long id,						//部门ID
			Model model,
			ServletRequest request) {
		Hospital hospital = basicService.queryHostpitalById(id);
		if (hospital != null) {
			model.addAttribute("hospitalBean", hospital);
		}
		return "inc/inc_depar_list_add_department_infos";
	}
	
	@RequestMapping("/inc_depar_list_edit_department_infos")
	public String basiDeparListEditDepartmentInfos(
			@RequestParam(value = "departmentId") Long id,						//部门ID
			Model model,
			ServletRequest request) {
		Department department = basicService.queryDepartmentById(id);
		if (department == null) {
			return "inc/inc_depar_list_add_hospital_infos";
		}
		Hospital hospital = basicService.queryHostpitalById(department.getHospitalId());
		if (hospital == null) {
			return "inc/inc_depar_list_add_hospital_infos";
		}
		model.addAttribute("departmentBean", department);
		model.addAttribute("hospitalBean", hospital);
		return "inc/inc_depar_list_add_department_infos";
	}
	
	@RequestMapping("/inc_depar_list_edit_hospital_infos")
	public String basiDeparListEditHospitalInfos(
			@RequestParam(value = "hospitalId") Long id,						//医院ID
			Model model,
			ServletRequest request) {
		Hospital hospital = basicService.queryHostpitalById(id);
		if (hospital != null) {
			model.addAttribute("hospitalBean", hospital);
		}
		return "inc/inc_depar_list_add_hospital_infos";
	}
	
	@RequestMapping("/inc_flowe_list_add")
	public String basiFloweListAdd() {
		return "inc/inc_flowe_list_add";
	}
	
	@RequestMapping("/inc_flowe_list_edit")
	public String basiFloweListEdit() {
		return "inc/inc_flowe_list_add";
	}
	
	@RequestMapping("/inc_flowe_list_add_infos")
	public String basiFloweListAddInfos() {
		return "inc/inc_flowe_list_add_infos";
	}
	
	@RequestMapping("/inc_flowe_list_add_imgs")
	public String basiFloweListAddImgs() {
		return "inc/inc_flowe_list_add_imgs";
	}
}
