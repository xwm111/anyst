package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Tap;

/*
 * 贴花JPA操作接口
 */
public interface TapDAO extends PagingAndSortingRepository<Tap, Long> {
	
	public Tap findByCode(String code);
	
	public Page<Tap> findByNameLike(String name, Pageable pageable);
	
	public Page<Tap> findByStatus(int status, Pageable pageable);
	
	public Page<Tap> findByCode(String code, Pageable pageable);
	
	public Page<Tap> findByNameLikeAndStatus(String name, int status, Pageable pageable);
	
	public Page<Tap> findByCodeAndNameLike(String code, String name, Pageable pageable);
	
	public Page<Tap> findByCodeAndStatus(String code, int status, Pageable pageable);
	
	public Page<Tap> findByCodeAndStatusAndNameLike(String code, int status, String name, Pageable pageable);
	
	@Modifying
	@Query("delete Tap t where t.code = ?1")
	public int deleteByCode(String code);
}
