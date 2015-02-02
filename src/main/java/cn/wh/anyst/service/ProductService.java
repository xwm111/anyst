package cn.wh.anyst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Product;
import cn.wh.anyst.repository.ProductDAO;

/*
 * 产品业务服务
 */
@Component
@Transactional
public class ProductService {

	@Autowired
	private ProductDAO productDao;
	
	/*
	 * 查找全部产品并且分页
	 */
	public Page<Product> listProduct(int pageNumber, int pageSize) {
		return productDao.findAll(new PageRequest(pageNumber - 1, pageSize));
	}
	
	/*
	 * 产品查询并且分页
	 */
	public Page<Product> queryProduct(String name, String code, int status, int pageNumber, int pageSize) {
		//查询所有产品
		if (name == null && code == null && status == -1) {
			return listProduct(pageNumber, pageSize);
		}
		
		//根据状态查找
		if (name == null && code == null && status != -1) {
			System.out.println("enter findByStatus");
			return productDao.findByStatus(status, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配查找
		if (name != null && code == null && status == -1) {
			System.out.println("enter findByNameLike");
			return productDao.findByNameLike("%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配和编码查找
		if (name != null && code != null && status == -1) {
			System.out.println("enter findByCodeAndNameLike");
			return productDao.findByCodeAndNameLike(code, "%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配、编码和绑定状态查找
		if (name != null && code != null && status != -1) {
			System.out.println("enter findByCodeAndStatusAndNameLike");
			return productDao.findByCodeAndStatusAndNameLike(code, status, "%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配和绑定状态查找
		if (name != null && status != -1) {
			System.out.println("enter findByNameLikeAndStatus");
			return productDao.findByNameLikeAndStatus("%" + name + "%", status, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据编码查找
		if (name == null && code != null && status == -1) {
			System.out.println("enter findByCode");
			return productDao.findByCode(code, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据编码和绑定状态查找
		if (name == null && code != null && status != -1) {
			System.out.println("enter findByCodeAndStatus");
			return productDao.findByCodeAndStatus(code, status, new PageRequest(pageNumber - 1, pageSize));
		}
		
		return null;
	}
	
	/*
	 * 通过产品编码查询单个产品
	 */
	public Product findByCode(String Code) {
		return productDao.findByCode(Code);
	}
	
	/*
	 * 新建产品
	 */
	public void newProduct(Product product) {
		productDao.save(product);
	}
	
	/*
	 * 更新产品
	 */
	public void updateProduct(Product product) {
		productDao.save(product);
	}
	
	/*
	 * 通过产品对象删除产品
	 */
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}
	
	/*
	 * 通过产品编码删除产品
	 */
	public int deleteProductByCode(String code) {
		return productDao.deleteByCode(code);
	}
	
}
