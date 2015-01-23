package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Customer;

public interface CustomerDAO extends PagingAndSortingRepository<Customer, Long> {

}
