package cn.wh.anyst.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.anyst.entity.CustomerGroup;
import cn.wh.anyst.entity.Department;
import cn.wh.anyst.entity.GiftGroup;
import cn.wh.anyst.entity.Hospital;
import cn.wh.anyst.entity.QueryHospitalResult;
import cn.wh.anyst.entity.Tap;
import cn.wh.anyst.repository.CustomerGroupDAO;
import cn.wh.anyst.repository.DepartmentDAO;
import cn.wh.anyst.repository.GiftGroupDAO;
import cn.wh.anyst.repository.HospitalDAO;
import cn.wh.anyst.repository.TapDAO;

/*
 * 基础数据业务服务
 */
@Component
@Transactional
public class BasicService {
	@Autowired
	private GiftGroupDAO giftGroupDao;
	@Autowired
	private TapDAO tapDao;
	@Autowired
	private CustomerGroupDAO customerGroupDao;
	@Autowired
	private DepartmentDAO departmentDao;
	@Autowired
	private HospitalDAO hospitalDao;
	
	/******************************************
	 * 客户分组相关接口 
	 ******************************************/
	
	/*
	 * 分页列出所有用户分组信息
	 */
	public Page<CustomerGroup> listCustomerGroup(int pageNumber, int pageSize) {
		return customerGroupDao.findAll(new PageRequest(pageNumber - 1, pageSize));
	}
	
	/*
	 * 根据用户分组名查找用户分组信息并分页
	 */
	public Page<CustomerGroup> queryCustomerGroup(String name, int pageNumber, int pageSize) {
		if (name == null) {
			return listCustomerGroup(pageNumber, pageSize);
		}
		return customerGroupDao.findByNameLike("%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
	}
	
	public CustomerGroup queryCustomerGroupByName(String name) {
		return customerGroupDao.findByName(name);
	}
	
	public CustomerGroup queryCustomerGroupById(Long id) {
		return customerGroupDao.findOne(id);
	}
	
	/*
	 * 列出所有用户分组
	 */
	public List<CustomerGroup> listAllCustomerGroup() {
		return Collections.unmodifiableList((List<CustomerGroup>)customerGroupDao.findAll());
	}
	
	/*
	 * 列出所有用户分组
	 */
	public List<CustomerGroup> listAllCustomerGroupIncludeAll() {
		ArrayList<CustomerGroup> result = new ArrayList<CustomerGroup>();
		result.addAll(Collections.unmodifiableList((List<CustomerGroup>)customerGroupDao.findAll()));
		CustomerGroup all = new CustomerGroup();
		all.setId(-1L);
		all.setName("所有");
		result.add(0, all);
		return result;
	}
	
	/*
	 * 创建新用户分组 
	 */
	public void createCustomerGroup(CustomerGroup customerGroup) {
		customerGroupDao.save(customerGroup);
	}
	
	/*
	 * 更新用户分组
	 */
	public void updateCustomerGroup(CustomerGroup customerGroup) {
		customerGroupDao.save(customerGroup);
	}
	
	/*
	 * 通过用户分组名删除用户分组
	 */
	public int deleteCustomerGroupByName(String name) {
		return customerGroupDao.deleteByName(name);
	}
	
	/*
	 * 通过用户分组ID删除分组
	 */
	public void deleteCustomerGroupById(Long id) {
		customerGroupDao.delete(id);
	}
	
	/*
	 * 通过用户分组对象删除分组
	 */
	public void deleteCustomerGroup(CustomerGroup customerGroup) {
		customerGroupDao.delete(customerGroup);
	}
	
	/******************************************
	 * 礼品分类相关接口
	 ******************************************/
	/*
	 * 分页列出所有礼品分类信息
	 */
	public Page<GiftGroup> listGiftGroup(int pageNumber, int pageSize) {
		return giftGroupDao.findAll(new PageRequest(pageNumber - 1, pageSize));
	}
	/*
	 * 查找礼品分类信息 
	 */
	public Page<GiftGroup> queryGiftGroup(String name, int pageNumber, int pageSize) {
		if (name == null) {
			return listGiftGroup(pageNumber, pageSize);
		}
		return giftGroupDao.findByNameLike("%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
	}
	
	public List<GiftGroup> listAllGiftGroup() {
		return Collections.unmodifiableList((List<GiftGroup>) giftGroupDao.findAll());
	}
	
	/*
	 * 通过ID查找礼品分类
	 */
	public GiftGroup queryGiftGroupById(Long id) {
		return giftGroupDao.findOne(id);
	}
	
	/*
	 * 创建新礼品分类 
	 */
	public void createGiftGroup(GiftGroup giftGroup) {
		giftGroupDao.save(giftGroup);
	}
	
	/*
	 * 更新礼品分类
	 */
	public void updateGiftGroup(GiftGroup giftGroup) {
		giftGroupDao.save(giftGroup);
	}
	
	/*
	 * 通过礼品分类名称删除礼品分类
	 */
	public int deleteGiftGroupByName(String name) {
		return giftGroupDao.deleteByName(name);
	}
	
	/*
	 * 通过礼品分类ID删除礼品分类
	 */
	public void deleteGiftGroupById(Long id) {
		giftGroupDao.delete(id);
	}
	
	/*
	 * 通过礼品分类对象删除分类
	 */
	public void deleteGiftGroup(CustomerGroup customerGroup) {
		customerGroupDao.delete(customerGroup);
	}
	
	/******************************************
	 * 医院信息服务接口
	 ******************************************/
	/*
	 * 分页列出所有医院及部门信息
	 */
	public QueryHospitalResult listHospital() {
		QueryHospitalResult result = new QueryHospitalResult();
		List<Hospital> hospitals = Collections.unmodifiableList((List<Hospital>) hospitalDao.findAll());
		if (hospitals != null && hospitals.size() > 0) {
			for (Hospital hospital : hospitals) {
				System.out.println("get hospital");
				result.getRows().addHospital(hospital);
				List<Department> departments = Collections.unmodifiableList(departmentDao.findByHospitalId(hospital.getId()));
				for (Department department : departments) {
					System.out.println("get department");
					result.getRows().addDepartment(department);
				}
			}
		}
		
		return result;
	}
	
	/*
	 * 列出所有医院信息
	 */
	public List<Hospital> listAllHospital() {
		return Collections.unmodifiableList((List<Hospital>) hospitalDao.findAll());
	}
	
	/*
	 * 列出所有医院信息含所有医院信息
	 */
	public List<Hospital> listAllHospitalIncludeAll() {
		ArrayList<Hospital> result = new ArrayList<Hospital>();
		result.addAll(Collections.unmodifiableList((List<Hospital>) hospitalDao.findAll()));
		Hospital all = new Hospital();
		all.setId(-1L);
		all.setHospitalName("所有");
		result.add(0, all);
		return result;
	}

	
	/*
	 * 根据医院ID列出所有部门
	 */
	public List<Department> listAllDepartment(Long hospitalId) {
		return Collections.unmodifiableList((List<Department>) departmentDao.findByHospitalId(hospitalId));
	}
	
	/*
	 * 根据医院ID列出所有部门
	 */
	public List<Department> listAllDepartmentIncludeAll(Long hospitalId) {
		ArrayList<Department> result = new ArrayList<Department>();
		result.addAll(Collections.unmodifiableList((List<Department>) departmentDao.findByHospitalId(hospitalId)));
		Department all = new Department();
		all.setId(-1L);
		all.setDepartmentName("所有");
		result.add(0, all);
		return result;
	}
	
	/*
	 * 通过ID查找医院信息
	 */
	public Hospital queryHostpitalById(Long id) {
		return hospitalDao.findOne(id);
	}
	
	/*
	 * 通过ID查找部门信息
	 */
	public Department queryDepartmentById(Long id) {
		return departmentDao.findOne(id);
	}
	
	/*
	 * 创建医院信息
	 */
	public void createHospital(Hospital hospital) {
		hospitalDao.save(hospital);
	}
	
	/*
	 * 创建部门信息
	 */
	public void createDepartment(Department department) {
		departmentDao.save(department);
	}
	
	/*
	 * 更新医院信息
	 */
	public void updateHospital(Hospital hospital) {
		hospitalDao.save(hospital);
	}
	
	/*
	 * 更新部门信息
	 */
	public void updateDepartment(Department department) {
		departmentDao.save(department);
	}
	
	/*
	 * 通过医院ID删除医院信息
	 */
	public void deleteHospitalById(Long id) {
		departmentDao.deleteByHospitalId(id);
		hospitalDao.delete(id);
	}
	
	/*
	 * 通过医院ID（H＋医院ID）删除医院信息
	 */
	public void deleteHospitalByStringId(String id) {
		if (id.startsWith("H")) {
			Long realId = Long.parseLong(id.substring(1, id.length() - 1));
			deleteHospitalById(realId);
		}
	}
	
	/*
	 * 通过医院对象商品医院及其部门
	 */
	public void deleteHospital(Hospital hospital) {
		departmentDao.deleteByHospitalId(hospital.getId());
		hospitalDao.delete(hospital);
	}
	
	/*
	 * 通过部门ID删除部门
	 */
	public void deleteDepartmentById(Long id) {
		departmentDao.delete(id);
	}
	
	/*
	 * 通过部门对象删除部门
	 */
	public void deleteDepartment(Department department) {
		departmentDao.delete(department);
	}
	
	/******************************************
	 * 贴花服务接口
	 ******************************************/
	/*
	 * 分页列出所有贴花信息返回分页
	 */
	public Page<Tap> listTap(int pageNumber, int pageSize) {
		return tapDao.findAll(new PageRequest(pageNumber - 1, pageSize));
	}
	
	/*
	 * 根据条件查询贴花信息返回分页
	 */
	public Page<Tap> queryTap(String name, String code, int status, int pageNumber, int pageSize) {
		//查询所有贴花
		if (name == null && code == null && status == -1) {
			return listTap(pageNumber, pageSize);
		}
		
		//根据状态查找
		if (name == null && code == null && status != -1) {
			return tapDao.findByStatus(status, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配查找
		if (name != null && code == null && status == -1) {
			return tapDao.findByNameLike("%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配和编码查找
		if (name != null && code != null && status == -1) {
			return tapDao.findByCodeAndNameLike(code, "%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配、编码和绑定状态查找
		if (name != null && code != null && status != -1) {
			return tapDao.findByCodeAndStatusAndNameLike(code, status, "%" + name + "%", new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据名称匹配和绑定状态查找
		if (name != null && status != -1) {
			return tapDao.findByNameLikeAndStatus("%" + name + "%", status, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据编码查找
		if (name == null && code != null && status == -1) {
			return tapDao.findByCode(code, new PageRequest(pageNumber - 1, pageSize));
		}
		
		//根据编码和绑定状态查找
		if (name == null && code != null && status != -1) {
			return tapDao.findByCodeAndStatus(code, status, new PageRequest(pageNumber - 1, pageSize));
		}
		
		return null;
	}
	
	/*
	 * 根据贴花Code查找贴花信息
	 */
	public Tap queryTapByCode(String code) {
		return tapDao.findByCode(code);
	}
	
	/*
	 * 创建贴花信息
	 */
	public void createTap(Tap tap) {
		tapDao.save(tap);
	}
	
	/*
	 * 更新贴花信息
	 */
	public void updateTap(Tap tap) {
		tapDao.save(tap);
	}
	
	/*
	 * 通过贴花Code删除贴花信息
	 */
	public int deleteTapByCode(String code) {
		return tapDao.deleteByCode(code);
	}
	
	/*
	 * 通过贴花对象删除贴花
	 */
	public void deleteTap(Tap tap) {
		tapDao.delete(tap);
	}
}
