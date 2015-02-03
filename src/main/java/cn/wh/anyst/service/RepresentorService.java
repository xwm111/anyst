package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Representor;
import cn.wh.anyst.repository.RepresentorDAO;

/*
 * 代表业务服务
 */
@Component
@Transactional
public class RepresentorService {
	
	@Autowired
	private RepresentorDAO representorDao;
	
	//查询
	public Page<Representor> listRepresentor(String name, int pageNumber, int pageSize) {
		if (name == null) {
			return representorDao.findAll(new PageRequest(pageNumber - 1, pageSize));
		} else {
			return representorDao.findByNameLike(name, new PageRequest(pageNumber - 1, pageSize));
		}
	}
	
	//通过ID查询代表
	public Representor queryRepresentor(Long id) {
		return representorDao.findOne(id);
	}
	
	//创建新代表对象
	public void createRepresentor(Representor representor) {
		representorDao.save(representor);
	}
	
	//更新代表对象
	public void updateRepresentor(Representor representor) {
		representorDao.save(representor);
	}
	
	//通过对象删除代表对象
	public void deleteRepresentor(Representor representor) {
		representorDao.delete(representor);
	}
	
	//通过ID删除代表对象
	public void deleteRepresentorById(Long id) {
		representorDao.delete(id);
	}
	
}
