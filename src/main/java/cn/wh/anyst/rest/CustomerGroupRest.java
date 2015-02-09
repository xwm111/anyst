package cn.wh.anyst.rest;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.anyst.entity.CustomerGroup;
import cn.wh.anyst.service.BasicService;

/*
 * 客户分组restful接口
 */
@RestController
@RequestMapping(value="/api/v1/group")
public class CustomerGroupRest {

	@Autowired
	private BasicService basicService;
	
	//列出所有客户分组并分页
	@RequestMapping(method = RequestMethod.GET)
	public RestQueryResultModal<CustomerGroup> list(
			@RequestParam(value = "customerGroupName", defaultValue = "") String customerGroupName,		//查询的分组名字
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, 							//分页第几页
			@RequestParam(value = "rows", defaultValue = RestCommonModal.PAGE_SIZE) int pageSize, 	   	//每页数量
            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,				   	//排序规则
            ServletRequest request) throws UnsupportedEncodingException {
		Page<CustomerGroup> groups = basicService.queryCustomerGroup(
				customerGroupName.equals("") ? null : new String(customerGroupName.getBytes("ISO-8859-1")), 
				pageNumber, 
				pageSize);
		RestQueryResultModal<CustomerGroup> result = new RestQueryResultModal<CustomerGroup>(groups.getTotalElements(), groups.getContent());
		return result;
	}
	
	//列出所有客户分组
	@RequestMapping(value = "/listAllCustomerGroup", method = RequestMethod.GET)
	public List<CustomerGroup> listAllCustomerGroup() {
		return basicService.listAllCustomerGroup();
	}
	
	//列出所有客户分组并包含所有
	@RequestMapping(value = "/listAllCustomerGroupIncludeAll", method = RequestMethod.GET)
	public List<CustomerGroup> listAllCustomerGroupIncludeAll() {
		return basicService.listAllCustomerGroupIncludeAll();
	}
	
	//通过ID查询组信息
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CustomerGroup list(@PathVariable("id") Long id) throws UnsupportedEncodingException {
		return basicService.queryCustomerGroupById(id);
	}
	
	//创建客户分组
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int create(
			@RequestParam(value = "customerGroupName") String name,										//分组名称
			@RequestParam(value = "customerGroupDescription") String description,						//分组描述
            ServletRequest request) {
		CustomerGroup customerGroup = new CustomerGroup();
		customerGroup.setName(name);
		customerGroup.setDescription(description);
		basicService.createCustomerGroup(customerGroup);
		return 1;
	}
	
	//更新客户分组
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(
			@RequestParam(value = "customerGroupId") Long id,											//分组ID
			@RequestParam(value = "customerGroupName") String name,										//分组名称
			@RequestParam(value = "customerGroupDescription") String description,						//分组描述
            ServletRequest request) {
		CustomerGroup customerGroup = basicService.queryCustomerGroupById(id);
		if (customerGroup != null) {
			customerGroup.setName(name);
			customerGroup.setDescription(description);
			basicService.updateCustomerGroup(customerGroup);
		}
		return 1;
	}
	
	//删除客户分组
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int delete(
			@RequestParam(value = "customerGroupId") Long id,										//分组ID
            ServletRequest request) {
		basicService.deleteCustomerGroupById(id);
		return 1;
	}
}
