package cn.wh.anyst.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 客服实体对象类
 */
@Entity
@Table(name = "anyst_service")
public class Service extends IdEntity {
	private String name;			//客服名字
	private String account;			//客服账号
	private String phone;			//客服电话
	private Date lastLogin;			//最后登录时间
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
}
