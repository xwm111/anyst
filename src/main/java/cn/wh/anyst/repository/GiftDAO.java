package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Gift;

/*
 * 礼物JPA操作接口
 */
public interface GiftDAO extends PagingAndSortingRepository<Gift, Long> {

}
