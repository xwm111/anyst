package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Department;

public interface DepartmentDAO extends PagingAndSortingRepository<Department, Long> {

}
