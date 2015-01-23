package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Tap;

public interface TapDAO extends PagingAndSortingRepository<Tap, Long> {

}
