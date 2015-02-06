package cn.wh.anyst.entity;

import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 客户实体对象
 */
@Entity
@Table(name = "anyst_customer")
public class Customer extends IdEntity {
	private String name;			//客户名称
	private String webchat;			//微信号
	private String mobileNumber;	//手机号码
	private String message;			//关注消息
	private Long hospital;			//医院ID
	private Long department;		//科室ID
	private Long customerGroup;				//分组ID (0 - 未分组)
	private int customerType;		//客户类型 (0 - 未确定, 1 - 医生, 2 - 护士)
	private int status;				//客户状态 (0 - 未确认, 1 - 确认)
	
	private String customerGroupName;	//用户分组名称
	private String hospitalName;		//用户所属医院名称
	private String departmentName;		//用户所属部门名称
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebchat() {
		return webchat;
	}
	public void setWebchat(String webchat) {
		this.webchat = webchat;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getHospital() {
		return hospital;
	}
	public void setHospital(Long hospital) {
		this.hospital = hospital;
	}
	public Long getDepartment() {
		return department;
	}
	public void setDepartment(Long department) {
		this.department = department;
	}
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getCustomerGroup() {
		return customerGroup;
	}
	public void setCustomerGroup(Long customerGroup) {
		this.customerGroup = customerGroup;
	}
	
	@Transient 
	public String getCustomerGroupName() {
		return customerGroupName;
	}
	public void setCustomerGroupName(String customerGroupName) {
		this.customerGroupName = customerGroupName;
	}
	@Transient 
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	@Transient 
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
