package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.CustomerGroup;

public interface CustomerGroupDAO extends PagingAndSortingRepository<CustomerGroup, Long> {

}
