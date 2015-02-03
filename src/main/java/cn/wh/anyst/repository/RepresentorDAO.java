package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Representor;

/*
 * 代表JPA操作接口
 */
public interface RepresentorDAO extends
		PagingAndSortingRepository<Representor, Long> {

	//通过代表名称查询
	Page<Representor> findByNameLike(String name, Pageable pageable);

}
