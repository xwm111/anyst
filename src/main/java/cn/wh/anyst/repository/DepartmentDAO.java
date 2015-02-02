package cn.wh.anyst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Department;

/*
 * 部门JPA操作接口
 */
public interface DepartmentDAO extends PagingAndSortingRepository<Department, Long> {
	
	//通过医院ID查询部门
	List<Department> findByHospitalId(Long id);
	
	//删除医院下的所有部门
	@Modifying
	@Query("delete Department d where d.hospitalId = ?1")
	int deleteByHospitalId(Long id);
}
