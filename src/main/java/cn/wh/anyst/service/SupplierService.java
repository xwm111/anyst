package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Supplier;
import cn.wh.anyst.repository.SupplierDAO;

/*
 * 经销商业务服务
 */
@Component
@Transactional
public class SupplierService {
	
	@Autowired
	private SupplierDAO supplierDao;
	
	//查询
	public Page<Supplier> listSupplier(String name, int pageNumber, int pageSize) {
		if (name == null) {
			return supplierDao.findAll(new PageRequest(pageNumber - 1, pageSize));
		} else {
			return supplierDao.findByNameLike(name, new PageRequest(pageNumber - 1, pageSize));
		}
	}
	
	//通过ID查询
	public Supplier querySupplier(Long id) {
		return supplierDao.findOne(id);
	}
	
	//创建新经销商对象
	public void createSupplier(Supplier supplier) {
		supplierDao.save(supplier);
	}
	
	//更新经销商对象
	public void updateSupplier(Supplier supplier) {
		supplierDao.save(supplier);
	}
	
	//删除经销商对象
	public void deleteSupplier(Supplier supplier) {
		supplierDao.delete(supplier);
	}
	
	//删除经销商对象
	public void deleteSupplier(Long id) {
		supplierDao.delete(id);
	}
}
