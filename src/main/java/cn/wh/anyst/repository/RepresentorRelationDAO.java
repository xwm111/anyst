package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.RepresentorRelation;

public interface RepresentorRelationDAO extends
		PagingAndSortingRepository<RepresentorRelation, Long> {

}
