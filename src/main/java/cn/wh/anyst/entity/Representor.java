package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 代表实体类
 */
@Entity
@Table(name = "anyst_representor")
public class Representor extends IdEntity {
	private String name;				//代表名称
	private Long supplier;				//供应商ID
	private String phone;				//电话号码
	private String webchat;				//微信号码
	private int status;					//状态(0 - 启用, 1 - 停用)
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSupplier() {
		return supplier;
	}
	public void setSupplier(Long supplier) {
		this.supplier = supplier;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebchat() {
		return webchat;
	}
	public void setWebchat(String webchat) {
		this.webchat = webchat;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	} 
}
