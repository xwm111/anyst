package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Customer;
import cn.wh.anyst.entity.Supplier;
import cn.wh.anyst.repository.CustomerDAO;

/*
 * 客户业务服务
 */
@Component
@Transactional
public class CustomerService {

	@Autowired
	private CustomerDAO customerDao;
	
	//查询
	public Page<Customer> listCustomer(String name, int pageNumber, int pageSize) {
		if (name == null) {
			return customerDao.findAll(new PageRequest(pageNumber - 1, pageSize));
		} else {
			return customerDao.findByNameLike(name, new PageRequest(pageNumber - 1, pageSize));
		}
	}
	
	//通过ID查询
	public Customer queryCustomer(Long id) {
		return customerDao.findOne(id);
	}
	
	//创建新客户对象
	public void createCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	//更新客户对象
	public void updateCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	//删除客户对象
	public void deleteCustomer(Customer customer) {
		customerDao.delete(customer);
	}
	
	//删除客户对象
	public void deleteCustomerById(Long id) {
		customerDao.delete(id);
	}

	//根据openId判断用户是否存在。不存在则创建新用户，存在则更新备注
	/**
	 * 
	 * @param openId 微信openId
	 * @param content 用户发来的备注信息
	 */
	public void CreateOrUpdateCustomer(String openId, String content) {
		// TODO 根据openId判断用户是否存在。不存在则创建新用户，存在则更新备注
		
	}

	/**
	 * 根据openID查询客户是否能够访问页面,openId对应的客户status =1的则返回ture
	 * @param openId
	 * @return
	 */
	public boolean checkCustomerByOpenId(String openId) {
		// TODO 根据openID查询客户是否能够访问页面,openId对应的客户status =1的则返回ture
		return true;
	}
}
