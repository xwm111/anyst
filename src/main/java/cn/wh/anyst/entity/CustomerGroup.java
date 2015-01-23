package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 客户分组实体类
 */
@Entity
@Table(name = "anyst_customer_group")
public class CustomerGroup extends IdEntity {
	private String name;		//分组名称
	private int num;			//分组当前客户数
	private int description;		//分组备注
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
}
