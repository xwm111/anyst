package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.ExchangeRule;

/*
 * 兑换规则JPA操作接口
 */
public interface ExchangeRuleDAO extends
		PagingAndSortingRepository<ExchangeRule, Long> {

}
