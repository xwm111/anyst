package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 兑换规则实体对象
 */
@Entity
@Table(name = "anyst_exchange_rules")
public class ExchangeRule extends IdEntity {
	private String gift;		//礼品编码
	private String product;		//产品编码
	private String tap;			//贴花编码
	private int value;
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTap() {
		return tap;
	}
	public void setTap(String tap) {
		this.tap = tap;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
