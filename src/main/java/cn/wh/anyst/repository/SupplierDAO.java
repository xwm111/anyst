package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Supplier;

/*
 * 供应商JPA操作接口
 */
public interface SupplierDAO extends PagingAndSortingRepository<Supplier, Long> {
	
	//通过名称查询
	Page<Supplier> findByNameLike(String name, Pageable pageable);

}
