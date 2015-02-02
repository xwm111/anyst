package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.GiftGroup;

/*
 * 礼物分组JPA操作接口
 */
public interface GiftGroupDAO extends PagingAndSortingRepository<GiftGroup, Long> {
	
	public Page<GiftGroup> findByNameLike(String name, Pageable pageable);
	
	@Modifying
	@Query("delete GiftGroup g where g.name = ?1")
	public int deleteByName(String name);
}
