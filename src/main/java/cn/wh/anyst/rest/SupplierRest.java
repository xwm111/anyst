package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Gift;
import cn.wh.anyst.entity.Supplier;
import cn.wh.anyst.service.SupplierService;

/*
 * 经销商restful接口
 */
@RestController
@RequestMapping("/api/v1/dist")
public class SupplierRest {
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Supplier> list(
			@RequestParam(value = "supplierName", defaultValue = "") String name,						//销售商名称或者销售上电话号码					
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 		//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,					//排序规则
            ServletRequest request
			) throws UnsupportedEncodingException {
		Page<Supplier> supplierPage = supplierService.listSupplier(
				(name.equals("") ? null : new String(name.getBytes("ISO-8859-1"))), 
				pageNumber, pageSize);
		RestQueryResultModal<Supplier> result = new RestQueryResultModal<Supplier>(supplierPage.getTotalElements(), supplierPage.getContent());
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam(value = "supplierName") String name,											//销售商名称
			@RequestParam(value = "supplierEmail") String email,										//销售商邮箱
			@RequestParam(value = "supplierPhone") String phone,										//销售商电话
			@RequestParam(value = "supplierDescription") String description,							//销售商描述						
            ServletRequest request
			) {
		Supplier supplier = new Supplier();
		supplier.setName(name);
		supplier.setEmail(email);
		supplier.setPhone(phone);
		supplier.setDescription(description);
		supplierService.createSupplier(supplier);
		return 1;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam(value = "supplierId") Long id,												//销售商ID
			@RequestParam(value = "supplierName") String name,											//销售商名称
			@RequestParam(value = "supplierEmail") String email,										//销售商邮箱
			@RequestParam(value = "supplierPhone") String phone,										//销售商电话
			@RequestParam(value = "supplierDescription") String description,							//销售商描述						
            ServletRequest request
			) {
		Supplier supplier = supplierService.querySupplier(id);
		if (supplier != null) {
			supplier.setName(name);
			supplier.setEmail(email);
			supplier.setPhone(phone);
			supplier.setDescription(description);
			supplierService.createSupplier(supplier);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(
			@RequestParam(value = "supplierId") Long id,												//销售商ID						
            ServletRequest request
			) {
		supplierService.deleteSupplier(id);
		return 1;
	}
}
