package cn.wh.anyst.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 日志实体对象
 */

@Entity
@Table(name = "anyst_logs")
public class Logs extends IdEntity {
	private int type;			//日志类型(1 - 产品日志，2 - 礼品日志，3 － 订单日志，4 － 库存日志，5 － 登录日志)
	private String content;		//日志内容
	private String account;		//操作人账号
	private String role;		//操作人角色
	private Date date;			//日志时间
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
