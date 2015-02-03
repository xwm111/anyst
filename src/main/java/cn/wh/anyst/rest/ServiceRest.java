package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Service;
import cn.wh.anyst.service.ServiceService;

/*
 * 客服服务restful接口
 */
@RestController
@RequestMapping("/api/v1/serv")
public class ServiceRest {
	@Autowired
	private ServiceService serviceService;
	
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Service> list(
			@RequestParam(value = "serviceName", defaultValue = "") String param,						//客服名字或者电话号码
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 		//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,					//排序规则
            ServletRequest request
			) throws UnsupportedEncodingException {
		Page<Service> servicePage = serviceService.listService(
				(param.equals("") ? null : new String(param.getBytes("ISO-8859-1"))), 
				pageNumber, pageSize);
		RestQueryResultModal<Service> result = new RestQueryResultModal<Service>(servicePage.getTotalElements(), servicePage.getContent());
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam(value = "serviceName") String name,											//客服名字
			@RequestParam(value = "serviceAccount") String account,										//客服账户
			@RequestParam(value = "servicePhone") String phone,											//客服电话
            ServletRequest request
			) {
		Service service = new Service();
		service.setName(name);
		service.setAccount(account);
		service.setPhone(phone);
		serviceService.createService(service);
		return 1;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam(value = "serviceId") Long id,													//客服ID
			@RequestParam(value = "serviceName") String name,											//客服名字
			@RequestParam(value = "serviceAccount") String account,										//客服账户
			@RequestParam(value = "servicePhone") String phone,											//客服电话
            ServletRequest request
			) {
		Service service = serviceService.queryServiceById(id);
		if (service != null) {
			service.setName(name);
			service.setAccount(account);
			service.setPhone(phone);
			serviceService.updateService(service);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(
			@RequestParam(value = "serviceId") Long id,													//客服ID						
            ServletRequest request
			) {
		serviceService.deleteServiceById(id);
		return 1;
	}
	
}
