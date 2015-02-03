package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.repository.ServiceDAO;

@Component
@Transactional
public class ServiceService {
	@Autowired
	private ServiceDAO serviceDao;
}
