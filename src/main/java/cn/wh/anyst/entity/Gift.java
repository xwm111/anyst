package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 礼品实体对象
 */
@Entity
@Table(name = "anyst_gift")
public class Gift extends IdEntity {
	private String code;			//礼品编码
	private String product;			//礼物对应的产品编码
	private String imgUrl1;			//礼品的图片链接地址1
	private String imgUrl2;			//礼品的图片链接地址2
	private String imgUrl3;			//礼品的图片链接地址3
	private String giftName;		//礼品的名称
	private String giftDiscribe;	//礼品的描述信息
	private int	   giftCost;		//礼品的成本 （分为单位）
	private int    giftPrice;		//礼品的市场价格 （分为单位）
	private Long   giftGroup;		//礼品分组ID
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getImgUrl1() {
		return imgUrl1;
	}
	public void setImgUrl1(String imgUrl1) {
		this.imgUrl1 = imgUrl1;
	}
	public String getImgUrl2() {
		return imgUrl2;
	}
	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}
	public String getImgUrl3() {
		return imgUrl3;
	}
	public void setImgUrl3(String imgUrl3) {
		this.imgUrl3 = imgUrl3;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getGiftDiscribe() {
		return giftDiscribe;
	}
	public void setGiftDiscribe(String giftDiscribe) {
		this.giftDiscribe = giftDiscribe;
	}
	public int getGiftCost() {
		return giftCost;
	}
	public void setGiftCost(int giftCost) {
		this.giftCost = giftCost;
	}
	public int getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(int giftPrice) {
		this.giftPrice = giftPrice;
	}
	public Long getGiftGroup() {
		return giftGroup;
	}
	public void setGiftGroup(Long giftGroup) {
		this.giftGroup = giftGroup;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
