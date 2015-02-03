package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Representor;
import cn.wh.anyst.service.RepresentorService;

/*
 * 代表restful接口
 */
@RestController
@RequestMapping("/api/v1/repr")
public class RepresentorRest {
	@Autowired
	private RepresentorService representorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Representor> list(
			@RequestParam(value = "representorName", defaultValue = "") String name,						//销售商名称						
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 		//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,					//排序规则
            ServletRequest request
			) throws UnsupportedEncodingException {
		Page<Representor> representorPage = representorService.listRepresentor(
				(name.equals("") ? null : new String(name.getBytes("ISO-8859-1"))), 
				pageNumber, pageSize);
		RestQueryResultModal<Representor> result = new RestQueryResultModal<Representor>(representorPage.getTotalElements(), representorPage.getContent());
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam(value = "representorName") String name,											//代表名字
			@RequestParam(value = "representorSupplier") Long supplier,										//代表所属供应商
			@RequestParam(value = "representorPhone") String phone,											//代表电话
			@RequestParam(value = "representorWebchat") String webchat,										//代表微信号
			@RequestParam(value = "representorStatus", defaultValue = "0") int status,						//代表状态
            ServletRequest request
			) {
		Representor representor = new Representor();
		representor.setName(name);
		representor.setWebchat(webchat);
		representor.setPhone(phone);
		representor.setStatus(status);
		representor.setSupplier(supplier);
		representorService.createRepresentor(representor);
		return 1;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam(value = "supplierId") Long id,													//代表ID
			@RequestParam(value = "representorName") String name,											//代表名字
			@RequestParam(value = "representorSupplier") Long supplier,										//代表所属供应商
			@RequestParam(value = "representorPhone") String phone,											//代表电话
			@RequestParam(value = "representorWebchat") String webchat,										//代表微信号
			@RequestParam(value = "representorStatus", defaultValue = "0") int status,						//代表状态
            ServletRequest request
			) {
		Representor representor = representorService.queryRepresentor(id);
		if (representor != null) {
			representor.setName(name);
			representor.setWebchat(webchat);
			representor.setPhone(phone);
			representor.setStatus(status);
			representor.setSupplier(supplier);
			representorService.updateRepresentor(representor);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(
			@RequestParam(value = "representorId") Long id,												//代表ID						
            ServletRequest request
			) {
		representorService.deleteRepresentorById(id);
		return 1;
	}
}
