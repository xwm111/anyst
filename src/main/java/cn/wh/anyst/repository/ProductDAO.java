package cn.wh.anyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Product;

/*
 * 产品JPA操作接口
 */
public interface ProductDAO extends PagingAndSortingRepository<Product, Long> {
	
	/*
	 * 通过产品编码查找产品
	 */
	public Product findByCode(String code);
	
	public Page<Product> findByNameLike(String name, Pageable pageable);
	
	public Page<Product> findByStatus(int status, Pageable pageable);
	
	public Page<Product> findByCode(String code, Pageable pageable);
	
	public Page<Product> findByNameLikeAndStatus(String name, int status, Pageable pageable);
	
	public Page<Product> findByCodeAndNameLike(String code, String name, Pageable pageable);
	
	public Page<Product> findByCodeAndName(String code, String name, Pageable pageable);
	
	public Page<Product> findByCodeAndStatus(String code, int status, Pageable pageable);
	
	public Page<Product> findByCodeAndStatusAndNameLike(String code, int status, String name, Pageable pageable);
	
	/*
	 * 通过产品编码删除产品
	 */
	@Modifying
	@Query("delete Product p where p.code = ?1")
	public int deleteByCode(String code);
}
