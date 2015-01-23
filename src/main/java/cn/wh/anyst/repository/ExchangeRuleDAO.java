package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.ExchangeRule;

public interface ExchangeRuleDAO extends
		PagingAndSortingRepository<ExchangeRule, Long> {

}
