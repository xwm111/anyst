package cn.wh.anyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.repository.LogsDAO;

@Component
@Transactional
public class LogService {
	
	@Autowired
	private LogsDAO logsDao;
	
}
