package cn.wh.anyst.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Logs;
import cn.wh.anyst.service.LogService;

/*
 * 日志restful接口服务
 */
@RestController
@RequestMapping("/api/v1/logs")
public class LogRest {
	
	@Autowired
	private LogService logService;
	
	//查询日志
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Logs> list(
			@RequestParam(value = "logType", defaultValue = "-1") int type,								//销售商名称
			@RequestParam(value = "logStartTime", defaultValue = "") String startTime,					//销售商名称
			@RequestParam(value = "logEndTime", defaultValue = "") String endTime,						//销售商名称
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 		//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,					//排序规则
            ServletRequest request
			) throws UnsupportedEncodingException, ParseException {
		Page<Logs> logsPage = logService.listLogs(
				type,
				new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").parse(startTime),
				new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").parse(endTime),
				pageNumber, pageSize);
		RestQueryResultModal<Logs> result = new RestQueryResultModal<Logs>(logsPage.getTotalElements(), logsPage.getContent());
		return result;
	}
	
	//导出Excel
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public int export(@RequestParam(value = "logType", defaultValue = "-1") int type,					//销售商名称
			@RequestParam(value = "logStartTime", defaultValue = "") String startTime,					//销售商名称
			@RequestParam(value = "logEndTime", defaultValue = "") String endTime,						//销售商名称
			ServletRequest request,
			ServletResponse response
			) throws ParseException, IOException {
		String path = logService.exportExcel(
				type,
				new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").parse(startTime),
				new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").parse(endTime));
		
		if (path != null) {
			File file = null;
			FileInputStream fis = null;
			BufferedOutputStream bos = null;
			try {
				file = new File(path);
				fis = new FileInputStream(file);
				response.setContentType("Application/X-EXCEL");
				response.setContentLength((int)file.getTotalSpace());
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buf = new byte[10240];
				int hasRead = 0;
				while ((hasRead = fis.read(buf, hasRead, buf.length)) > 0) {
					bos.write(buf, 0, hasRead);
				}
				bos.flush();
			} finally {
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {	
					}
				}
				
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
					}
				}
			}
			return 1;
		}
		
		return 0;
	}
}
