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
	
	/*
	public Page<ExchangeHistory> listExchangeHistory() {
		
	}
	*/
}
