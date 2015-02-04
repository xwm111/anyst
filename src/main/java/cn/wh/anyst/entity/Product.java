package cn.wh.anyst.entity;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 产品实体对象
 */
@Entity
@Table(name = "anyst_product")
public class Product extends IdEntity {
	private String code;				//产品编号
	private String name;				//产品名称
	private Long supplier;				//产品供应商ID
	private String description;			//产品描述
	private String productImgUrls;		//产品图片链接
	private String tapImgUrls;			//产品贴画图片链接
	private int status;					//产品状态（0 － 未绑定贴花，1 － 已经绑定贴花）
	
	@Column(nullable=false)
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String describe) {
		this.description = describe;
	}
	public String getProductImgUrls() {
		return productImgUrls;
	}
	public void setProductImgUrls(String productImgUrls) {
		this.productImgUrls = productImgUrls;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTapImgUrls() {
		return tapImgUrls;
	}
	public void setTapImgUrls(String tapImgUrls) {
		this.tapImgUrls = tapImgUrls;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	@Transient
	public String getOpt() {
		return this.code;
	}
}
