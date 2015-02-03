package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Service;

/*
 * 客服JPA操作接口
 */
public interface ServiceDAO extends PagingAndSortingRepository<Service, Long>{

}
