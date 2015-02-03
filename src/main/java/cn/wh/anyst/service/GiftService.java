package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Gift;
import cn.wh.anyst.repository.GiftDAO;

/*
 * 礼物业务服务
 */
@Component
@Transactional
public class GiftService {
	
	@Autowired
	private GiftDAO giftDao;
	
	/*
	 * 查询礼品服务
	 */
	public Page<Gift> listGift(String name, String code, Long groupId, int pageNumber, int pageSize) {
		//没有选择任何过滤条件
		if (name == null && code == null && groupId == -1) {
			return giftDao.findAll(new PageRequest(pageNumber - 1, pageSize));
		}
		
		//只选择分组进行过滤
		if (name == null && code == null && groupId != -1) {
			return giftDao.findByGiftGroup(groupId, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//只选择编码进行过滤
		if (name == null && code != null && groupId == -1) {
			return giftDao.findByCode(code, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//只选择名称进行过滤
		if (name != null && code == null && groupId == -1) {
			return giftDao.findByGiftNameLike(name, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//选择礼品名称和编码进行过滤
		if (name != null && code != null && groupId == -1) {
			return giftDao.findByGiftNameLikeAndCode(name, code, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//选择礼品名称和分组进行过滤
		if (name != null && code == null && groupId != -1) {
			return giftDao.findByGiftNameLikeAndGiftGroup(name, groupId, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//选择礼品编码和分组进行过滤
		if (name == null && code != null && groupId != -1) {
			return giftDao.findByCodeAndGiftGroup(code, groupId, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//选择所有条件进行过滤
		if (name != null && code != null && groupId != -1) {
			return giftDao.findByGiftNameLikeAndCodeAndGiftGroup(name, code, groupId, new PageRequest(pageNumber - 1, pageSize));
		}
		
		return null;
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
