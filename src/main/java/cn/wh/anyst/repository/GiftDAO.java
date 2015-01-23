package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Gift;

public interface GiftDAO extends PagingAndSortingRepository<Gift, Long> {

}
