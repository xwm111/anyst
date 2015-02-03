package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.Customer;
import cn.wh.anyst.service.CustomerService;

/*
 * 客户restful接口
 */
@RestController
@RequestMapping(value="/api/v1/cust")
public class CustomerRest {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<Customer> list(
			@RequestParam(value = "representorName", defaultValue = "") String name,					//客户名称						
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 		//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,					//排序规则
            ServletRequest request
			) throws UnsupportedEncodingException {
		Page<Customer> customerPage = customerService.listCustomer(
				(name.equals("") ? null : new String(name.getBytes("ISO-8859-1"))), 
				pageNumber, pageSize);
		RestQueryResultModal<Customer> result = new RestQueryResultModal<Customer>(customerPage.getTotalElements(), customerPage.getContent());
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam(value = "customerName") String name,												//客户名字
			@RequestParam(value = "customerGroup") Long group,												//客户分组
			@RequestParam(value = "customerPhone") String phone,											//客户电话
			@RequestParam(value = "customerWebchat") String webchat,										//客户微信号
			@RequestParam(value = "customerMessage") String message,										//客户关注消息
			@RequestParam(value = "customerHospital") Long hospitalId,										//医院ID
			@RequestParam(value = "customerDepartment") Long departmentId,									//部门ID
			@RequestParam(value = "customerType", defaultValue = "-1") int type,							//客户类型
			@RequestParam(value = "customerStatus", defaultValue = "0") int status,							//客户状态
            ServletRequest request
			) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setCustomerType(type);
		customer.setDepartment(departmentId);
		customer.setHospital(hospitalId);
		customer.setMessage(message);
		customer.setMobileNumber(phone);
		customer.setStatus(status);
		customer.setWebchat(webchat);
		customerService.createCustomer(customer);
		return 1;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam(value = "customerId") Long id,													//客户ID
			@RequestParam(value = "customerName") String name,												//客户名字
			@RequestParam(value = "customerGroup") Long group,												//客户分组
			@RequestParam(value = "customerPhone") String phone,											//客户电话
			@RequestParam(value = "customerWebchat") String webchat,										//客户微信号
			@RequestParam(value = "customerMessage") String message,										//客户关注消息
			@RequestParam(value = "customerHospital") Long hospitalId,										//医院ID
			@RequestParam(value = "customerDepartment") Long departmentId,									//部门ID
			@RequestParam(value = "customerType", defaultValue = "-1") int type,							//客户类型
			@RequestParam(value = "customerStatus", defaultValue = "0") int status,							//客户状态
            ServletRequest request
			) {
		Customer customer = customerService.queryCustomer(id);
		if (customer != null) {
			customer.setName(name);
			customer.setCustomerType(type);
			customer.setDepartment(departmentId);
			customer.setHospital(hospitalId);
			customer.setMessage(message);
			customer.setMobileNumber(phone);
			customer.setStatus(status);
			customer.setWebchat(webchat);
			customerService.updateCustomer(customer);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(
			@RequestParam(value = "representorId") Long id,												//代表ID						
            ServletRequest request
			) {
		customerService.deleteCustomerById(id);
		return 1;
	}
}
