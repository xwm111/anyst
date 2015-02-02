package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Tap;
import cn.wh.anyst.service.BasicService;

@RestController
@RequestMapping("/api/v1/tap")
public class TapRest {

	@Autowired
	private BasicService basicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Tap> list(
			@RequestParam(value = "tapCode", defaultValue = "") String tapCode,									//贴花Code
			@RequestParam(value = "tapName", defaultValue = "") String tapName,									//贴花名称
			@RequestParam(value = "tapStatus", defaultValue = "-1") int tapStatus,								//贴花状态
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 									//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 				//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,							//排序规则
            ServletRequest request) throws UnsupportedEncodingException {
		Page<Tap> tapPage = basicService.queryTap(
				(tapName.equals("") ? null : new String(tapName.getBytes("ISO-8859-1"))),
				(tapCode.equals("") ? null : tapCode),
				tapStatus,
				pageNumber, pageSize);
		RestQueryResultModal<Tap> result = new RestQueryResultModal<Tap>(tapPage.getTotalElements(), tapPage.getContent());
		return result;
	}
	
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public Tap list(@PathVariable("tapCode") String code) {
		return basicService.queryTapByCode(code);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam("tapCode") String code,								//贴花代码
			@RequestParam(value = "tapStatus", defaultValue = "0") int status,	//贴花状态
            @RequestParam("tapDescription") String description,					//贴花描述
            @RequestParam("tapName") String name,								//贴花名称
            ServletRequest request) {
		Tap tap = new Tap();
		tap.setCode(code);
		tap.setDescription(description);
		tap.setStatus(status);
		tap.setName(name);
		basicService.createTap(tap);
		return 1;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam("tapCode") String code,								//贴花代码
			@RequestParam(value = "tapStatus", defaultValue = "0") int status,	//贴花状态
            @RequestParam("tapDescription") String description,					//贴花描述
            @RequestParam("tapName") String name,								//贴花名称
            ServletRequest request) {
		Tap tap = basicService.queryTapByCode(code);
		if (tap != null) {
			tap.setName(name);
			tap.setDescription(description);
			tap.setStatus(status);
			basicService.updateTap(tap);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(@RequestParam("tapCode") String code,						//产品代码
            ServletRequest request) {
		return basicService.deleteTapByCode(code);
	}
}
