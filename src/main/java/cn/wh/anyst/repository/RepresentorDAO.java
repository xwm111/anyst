package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Representor;

/*
 * 代表JPA操作接口
 */
public interface RepresentorDAO extends
		PagingAndSortingRepository<Representor, Long> {

}
