package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 礼品分组实体类
 */
@Entity
@Table(name = "anyst_gift_group")
public class GiftGroup extends IdEntity {
	private String name;		//分组名称
	private int num;			//分组当前礼品数
	private String description;	//分组备注
	private int displayOrder;	//排序序号
	private int isDisplay;		//是否显示 (1 - 显示, 0 - 不显示)
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String describe) {
		this.description = describe;
	}
	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int order) {
		this.displayOrder = order;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}
}
