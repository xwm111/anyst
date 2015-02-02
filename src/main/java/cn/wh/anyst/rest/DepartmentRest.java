package cn.wh.anyst.rest;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Department;
import cn.wh.anyst.entity.Hospital;
import cn.wh.anyst.entity.QueryHospitalResult;
import cn.wh.anyst.service.BasicService;

@RestController
@RequestMapping(value = "/api/v1/depar")
public class DepartmentRest {

	@Autowired
	private BasicService basicService;
	
	//列出所有医院及部门
	@RequestMapping(method = RequestMethod.GET)
	public QueryHospitalResult list(
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 	   	//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,				   	//排序规则
            ServletRequest request) {
		System.out.println("list hospital");
		return basicService.listHospital();
	}
	
	//新增医院
	@RequestMapping(value = "/createHospital", method = RequestMethod.POST)
	public int createHospital(
			@RequestParam(value = "hospitalName") String hospitalName, 					// 医院名称
			ServletRequest request) {
		Hospital hospital = new Hospital();
		hospital.setHospitalName(hospitalName);
		basicService.createHospital(hospital);
		return 1;
	}
	
	//新增部门
	@RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
	public int createDepartment(
			@RequestParam(value = "departmentName") String departmentName, 				// 医院名称
			@RequestParam(value = "hospitalId") Long id,								// 医院ID
			ServletRequest request) {
			Department department = new Department();
			department.setHospitalId(id);
			department.setDepartmentName(departmentName);
			basicService.createDepartment(department);
		return 1;
	}
	
	//更新医院
	@RequestMapping(value = "/updateHospital", method = RequestMethod.POST)
	public int updateHospital(
			@RequestParam(value = "hospitalId") Long id,								// 医院ID
			@RequestParam(value = "hospitalName") String hospitalName, 					// 医院名称
			ServletRequest request) {
		Hospital hospital = basicService.queryHostpitalById(id);
		if (hospital != null) {
			hospital.setHospitalName(hospitalName);
			basicService.updateHospital(hospital);
			return 1;
		}
		return 0;
	}
	
	//更新部门
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
	public int updateDepartment(
			@RequestParam(value = "departmentName") String departmentName, 				// 部门名称
			@RequestParam(value = "departmentId") Long id,								// 部门ID
			ServletRequest request) {
		Department department = basicService.queryDepartmentById(id);
		if (department != null) {
			department.setDepartmentName(departmentName);
			basicService.updateDepartment(department);
			return 1;
		}
			
		return 0;
	}
	
	//删除医院
	@RequestMapping(value = "/deleteHospital", method = RequestMethod.POST)
	public int deleteHospital(
			@RequestParam(value = "hospitalId") Long id,								// 医院ID
			ServletRequest request) {
		basicService.deleteHospitalById(id);
		return 1;
	}
	
	//更新部门
	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
	public int deleteDepartment(
			@RequestParam(value = "departmentId") Long id,								// 部门ID
			ServletRequest request) {
		System.out.println("id = " + id);
		basicService.deleteDepartmentById(id);
		return 1;
	}
}
