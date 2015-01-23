package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 登陆用户实体类
 */
@Entity
@Table(name = "anyst_loginUser")
public class LoginUser extends IdEntity {
	private String userName;		//用户登陆名
	private String userPassword;	//用户密码
	private int userType;			//用户类型	(0 - 管理员, 1 - 用户)
	private int referType;			//引用ID类型	(0 - 管理员, 1 - 客服, 2 - 供应商, 3 - 代表)
	private Long referId;			//应用ID
	private int status;				//状态 (0 - 启用, 1 - 停用)
	private String description;		//用户信息备注
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getReferType() {
		return referType;
	}
	public void setReferType(int referType) {
		this.referType = referType;
	}
	public Long getReferId() {
		return referId;
	}
	public void setReferId(Long referId) {
		this.referId = referId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String describe) {
		this.description = describe;
	}
}
