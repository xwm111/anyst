package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Customer;

/*
 * 客户JPA操作接口
 */
public interface CustomerDAO extends PagingAndSortingRepository<Customer, Long> {

}
