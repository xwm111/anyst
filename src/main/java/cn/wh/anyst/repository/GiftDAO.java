package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Gift;

/*
 * 礼物JPA操作接口
 */
public interface GiftDAO extends PagingAndSortingRepository<Gift, Long> {

	//通过礼品编码查询单个对象
	public Gift findByCode(String code);
	
	//通过礼品分组查找
	public Page<Gift> findByGiftGroup(Long groupId, Pageable pageable);

	//通过编码查找
	public Page<Gift> findByCode(String code, Pageable pageable);
	
	//通过名称进行查找
	public Page<Gift> findByGiftNameLike(String name, Pageable pageable);
	
	//通过礼品名称和编码分组查找
	public Page<Gift> findByGiftNameLikeAndCode(String name, String code, Pageable pageable);

	//通过礼品名称和分组进行查找
	public Page<Gift> findByGiftNameLikeAndGiftGroup(String name, Long groupId, Pageable pageable);

	//通过礼品编码和分组查找
	public Page<Gift> findByCodeAndGiftGroup(String code, Long groupId, Pageable pageable);

	//通过礼品名称、礼品编码和分组查找
	public Page<Gift> findByGiftNameLikeAndCodeAndGiftGroup(String name,
			String code, Long groupId, Pageable pageable);
	
	/*
	 * 通过礼品编码删除礼品
	 */
	@Modifying
	@Query("delete Gift g where g.code = ?1")
	public int deleteByCode(String code);
}
