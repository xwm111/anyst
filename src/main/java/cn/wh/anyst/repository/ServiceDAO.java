package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Service;

/*
 * 客服JPA操作接口
 */
public interface ServiceDAO extends PagingAndSortingRepository<Service, Long>{
	
	//通过名字或者电话好吗查找客服
	Page<Service> findByNameLikeOrPhoneLike(String name, String phone, Pageable pageable);
	
	//通过账号查询客服信息
	Service findByAccount(String account);
}
