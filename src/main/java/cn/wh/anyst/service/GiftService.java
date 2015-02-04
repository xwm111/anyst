package cn.wh.anyst.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Gift;
import cn.wh.anyst.entity.GiftGroup;
import cn.wh.anyst.entity.Product;
import cn.wh.anyst.entity.Tap;
import cn.wh.anyst.repository.GiftDAO;
import cn.wh.anyst.repository.GiftGroupDAO;
import cn.wh.anyst.repository.ProductDAO;
import cn.wh.anyst.repository.TapDAO;

/*
 * 礼物业务服务
 */
@Component
@Transactional
public class GiftService {
	
	@Autowired
	private GiftDAO giftDao;
	
	@Autowired 
	private ProductDAO productDao;
	
	@Autowired
	private TapDAO tapDao;
	
	@Autowired
	private GiftGroupDAO giftGroupDao;
	
	/*
	 * 查询礼品服务
	 */
	public Page<Gift> listGift(final String name, final String code, final Long groupId, final int status, int pageNumber, int pageSize) {
		
		Page<Gift> result = null;
		
		//没有选择任何过滤条件
		if (name == null && code == null && groupId == -1 && status == -1) {
			result = giftDao.findAll(new PageRequest(pageNumber - 1, pageSize));
		} else {
			//牛逼的组合查询
			result = giftDao.findAll(new Specification<Gift>() {
				@Override
				public Predicate toPredicate(Root<Gift> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					Path<String> fieldName = root.get("giftName");
					Path<Long> fieldGroupId = root.get("giftGroup");
					Path<Integer> fieldStatus = root.get("status");
					Path<String> fieldCode = root.get("code");
					
					Predicate p = null;
					
					if (name != null) {
						p = cb.like(fieldName, "%" + name + "%");
					}
					
					if (code != null) {
						if (p != null) {
							p = cb.and(p, cb.equal(fieldCode, code));
						} else {
							p = cb.equal(fieldCode, code);
						}
						
					}
					
					if (groupId != -1) {
						if (p != null) {
							p = cb.and(p, cb.equal(fieldGroupId, groupId));
						} else {
							p = cb.equal(fieldGroupId, groupId);
						}
					}
					
					if (status != -1) {
						if (p != null) {
							p = cb.and(p, cb.equal(fieldStatus, status));
						} else {
							p = cb.equal(fieldStatus, status);
						}
					}
					
					return p;
				}
				
			}, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//为每个对象查找分组的组名、贴花的图片地址、产品分组名称
		if (result != null) {
			List<Gift> gifts = result.getContent();
			for (Gift gift : gifts) {
				String productCode = gift.getProduct();
				Product product = productDao.findByCode(productCode);
				if (product == null) {
					gift.setProductName("绑定的产品不存在");
				} else {
					gift.setProductName(product.getName());
				}
				
				Tap tap = tapDao.findByProductAndStatus(productCode, 1);
				if (tap != null) {
					gift.setTapImgUrls(tap.getImgUrl());
				}
				
				GiftGroup group = giftGroupDao.findOne(gift.getGiftGroup());
				if (group != null) {
					gift.setGiftGroupName(group.getName());
				}
			}
		}
		
		return result;
		
	}
	
	/*
	 * 通过礼品编码查询礼品
	 */
	public Gift queryGiftByCode(String code) {
		return giftDao.findByCode(code);
	}

	/*
	 * 创建礼品
	 */
	public void createGift(Gift gift) {
		giftDao.save(gift);
	}
	
	/*
	 * 更新礼品
	 */
	public void updateGift(Gift gift) {
		giftDao.save(gift);
	}
	
	/*
	 * 通过对象删除礼品
	 */
	public void deleteGift(Gift gift) {
		giftDao.delete(gift);
	}
	
	/*
	 * 通过礼品ID删除礼品
	 */
	public void deleteGiftById(Long id) {
		giftDao.delete(id);
	}
	
	/*
	 * 通过礼品编码删除礼品
	 */
	public void deleteGiftByCode(String code) {
		giftDao.deleteByCode(code);
	}
}
