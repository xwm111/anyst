package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.ExchangeHistory;

public interface ExchangeHistoryDAO extends PagingAndSortingRepository<ExchangeHistory, Long> {

}
