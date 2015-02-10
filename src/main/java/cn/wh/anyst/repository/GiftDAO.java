package cn.wh.anyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Gift;

/*
 * 礼物JPA操作接口
 */
public interface GiftDAO extends PagingAndSortingRepository<Gift, Long>, JpaSpecificationExecutor<Gift> {

	//通过礼品编码查询单个对象
	public Gift findByCode(String code);
	
	@Query("select distinct g.giftGroup from Gift g where g.product = ?1")
	public List<Long> findDistinctGiftGroupByProduct(String productCode);
	
	public Page<Gift> findByProductAndGiftGroupAndExchangeValueBetween(String product, Long groupId, int min, int max, Pageable pageable);
	
	/*
	 * 通过礼品编码删除礼品
	 */
	@Modifying
	@Query("delete Gift g where g.code = ?1")
	public int deleteByCode(String code);
}
