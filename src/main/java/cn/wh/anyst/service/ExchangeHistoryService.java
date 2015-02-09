package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.ExchangeHistory;
import cn.wh.anyst.repository.ExchangeHistoryDAO;

/*
 * 兑换历史业务服务
 */
@Component
@Transactional
public class ExchangeHistoryService {
	
	@Autowired
	private ExchangeHistoryDAO exchangeHistoryDAO;

	//根据礼品id创建订单，客户信息从session中取，
	public void orderGift(String id) {
		// TODO 根据礼品id创建订单，客户信息从session中取，创建订单之后，需要通过微信发消息给此客户相关的代表
		
	}
	
	/*
	public Page<ExchangeHistory> listExchangeHistory() {
		
	}
	*/
}
