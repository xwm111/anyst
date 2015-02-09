package cn.wh.anyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.GiftGroup;

/*
 * 礼物分组JPA操作接口
 */
public interface GiftGroupDAO extends PagingAndSortingRepository<GiftGroup, Long>, JpaSpecificationExecutor<GiftGroup> {
	
	public Page<GiftGroup> findByNameLike(String name, Pageable pageable);
	
	public List<GiftGroup> findByIdIn(List<Long> ids);
	
	@Modifying
	@Query("delete GiftGroup g where g.name = ?1")
	public int deleteByName(String name);
}
