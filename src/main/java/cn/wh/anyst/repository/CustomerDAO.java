package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Customer;

/*
 * 客户JPA操作接口
 */
public interface CustomerDAO extends PagingAndSortingRepository<Customer, Long> {

	//通过名字查找客户信息
	Page<Customer> findByNameLike(String name, Pageable pageable);

}
