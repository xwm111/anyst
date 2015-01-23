package cn.wh.anyst.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 兑换历史实体类
 */
@Entity
@Table(name = "anyst_exchangeHistory")
public class ExchangeHistory extends IdEntity {
	private Date submitDate;		//申请时间
	private Date applyDate;			//发送时间
	private Long customer;			//客户ID;
	private Long representor;		//代表ID;
	private Long product;			//产品ID;
	private Long gift;				//礼物ID;
	private int giftNum;			//兑换礼物数;
	private int tapNum;				//使用贴花数;
	private String shipNum;			//快递单号;
	private int status;				//状态(0 - 申请, 1 - 完成, 2 - 取消)
	private String description;		//备注
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	public Long getRepresentor() {
		return representor;
	}
	public void setRepresentor(Long representor) {
		this.representor = representor;
	}
	public Long getProduct() {
		return product;
	}
	public void setProduct(Long product) {
		this.product = product;
	}
	public Long getGift() {
		return gift;
	}
	public void setGift(Long gift) {
		this.gift = gift;
	}
	public int getGiftNum() {
		return giftNum;
	}
	public void setGiftNum(int giftNum) {
		this.giftNum = giftNum;
	}
	public int getTapNum() {
		return tapNum;
	}
	public void setTapNum(int tapNum) {
		this.tapNum = tapNum;
	}
	public String getShipNum() {
		return shipNum;
	}
	public void setShipNum(String shipNum) {
		this.shipNum = shipNum;
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
