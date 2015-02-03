package cn.wh.anyst.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.service.LogService;

@RestController
@RequestMapping("/api/v1/logs")
public class LogRest {
	
	@Autowired
	private LogService logService;

}
