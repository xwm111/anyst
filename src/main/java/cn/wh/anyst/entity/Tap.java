package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 贴画实体类
 */
@Entity
@Table(name = "anyst_taps")
public class Tap extends IdEntity {
	private String code;		//贴花编号
	private String name;		//贴花名称
	private Long product;		//贴花对应产品ID
	private String imgUrl;		//贴花图片地址
	private int status;			//贴画状态 (0 - 启用, 1 - 停用)
	private String description; //贴花说明
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getProduct() {
		return product;
	}
	public void setProduct(Long product) {
		this.product = product;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String getOpt() {
		return this.code;
	}
}
