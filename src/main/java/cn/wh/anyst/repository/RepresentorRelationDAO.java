package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.RepresentorRelation;

/*
 * 代表关系JPA操作接口
 */
public interface RepresentorRelationDAO extends
		PagingAndSortingRepository<RepresentorRelation, Long> {

}
