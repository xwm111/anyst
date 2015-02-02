package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.repository.RepresentorDAO;

/*
 * 代表业务服务
 */
@Component
@Transactional
public class RepresentorService {
	
	@Autowired
	private RepresentorDAO representorDao;
}
