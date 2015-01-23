package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 部门实体对象
 */
@Entity
@Table(name = "anyst_department")
public class Department extends IdEntity {
	private String departmentName;		//科室名称
	private String departmentCode;		//科室编码
	private String hospitalCode;		//医院编码
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
}
