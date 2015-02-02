package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.repository.GiftDAO;

/*
 * 礼物业务服务
 */
@Component
@Transactional
public class GiftService {
	@Autowired
	private GiftDAO giftDao;
	
	
}
