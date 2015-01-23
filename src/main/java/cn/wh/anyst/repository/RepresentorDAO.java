package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Representor;

public interface RepresentorDAO extends
		PagingAndSortingRepository<Representor, Long> {

}
