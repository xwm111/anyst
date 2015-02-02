package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.CustomerGroup;

/*
 * 客户JPA操作接口
 */
public interface CustomerGroupDAO extends PagingAndSortingRepository<CustomerGroup, Long> {

	//通过名称精确查找
	public CustomerGroup findByName(String name);
	
	//通过名称匹配查找
	public Page<CustomerGroup> findByNameLike(String name, Pageable pageable);
	
	@Modifying
	@Query("delete CustomerGroup c where c.name = ?1")
	public int deleteByName(String name);
}
