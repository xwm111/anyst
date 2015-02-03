package cn.wh.anyst.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.Logs;
import cn.wh.anyst.repository.LogsDAO;

@Component
@Transactional
public class LogService {
	
	@Autowired
	private LogsDAO logsDao;
	
	public Page<Logs> listLogs(int type, Date startTime, Date endTime, int pageNumber, int pageSize) {
		return null; 
	}
	
	public String exportExcel(int type, Date startTime, Date endTime) {
		return null;
	}
}
