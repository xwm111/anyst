package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Service;
import cn.wh.anyst.repository.ServiceDAO;

/*
 * 客服业务接口服务
 */
@Component
@Transactional
public class ServiceService {
	@Autowired
	private ServiceDAO serviceDao;
	
	//通过名字匹配查询客服信息
	public Page<Service> listService(String name, int pageNumber, int pageSize) {
		if (name != null) {
			return serviceDao.findAll(new PageRequest(pageNumber - 1, pageSize));
		} else {
			return serviceDao.findByNameLikeOrPhoneLike(name, name, new PageRequest(pageNumber - 1, pageSize));
		}
	}
	
	//通过客服ID查询客服信息
	public Service queryServiceById(Long id) {
		return serviceDao.findOne(id);
	}
	
	//通过账号查找客服信息
	public Service queryServiceByAccount(String account) {
		return serviceDao.findByAccount(account);
	}
	
	//创建客服信息
	public int createService(Service service) {
		serviceDao.save(service);
		return 1;
	}
	
	//更新客服信息
	public int updateService(Service service) {
		serviceDao.save(service);
		return 1;
	}
	
	//通过ID删除客服
	public int deleteServiceById(Long id) {
		serviceDao.delete(id);
		return 1;
	}
	
	//通过对象删除客服
	public int deleteService(Service service) {
		serviceDao.delete(service);
		return 1;
	}
}
