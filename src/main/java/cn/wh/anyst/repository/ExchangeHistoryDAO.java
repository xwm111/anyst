package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.ExchangeHistory;

/*
 * 订单JPA操作接口
 */
public interface ExchangeHistoryDAO extends PagingAndSortingRepository<ExchangeHistory, Long> {

}
