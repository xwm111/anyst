package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 供应商实体类
 */
@Entity
@Table(name = "anyst_supplier")
public class Supplier extends IdEntity {
	private String name;		//供应商名称
	private String description;	//供应商描述
	private String email;		//供应商邮件地址
	private String phone;		//供应商联系电话
	private int status;			//供应商状态(0 - 停用, 1 - 启用)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String describe) {
		this.description = describe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
