package cn.wh.anyst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 代表业务关系实体类
 */
@Entity
@Table(name = "anyst_representor_relation")
public class RepresentorRelation extends IdEntity {
	private Long representor;				//代表ID		
	private Long product;					//产品ID
	private Long customer;					//客户ID
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
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	
	
}
