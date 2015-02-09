package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Supplier;

/*
 * 供应商JPA操作接口
 */
public interface SupplierDAO extends PagingAndSortingRepository<Supplier, Long> {
	
	//通过名称、电话号码或者邮箱地址模糊查询
	Page<Supplier> findByNameLikeOrPhoneLikeOrEmailLike(String name,
			String phone, String email, Pageable pageable);

}
