package cn.wh.anyst.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Hospital;

/*
 * 医院JPA操作接口
 */
public interface HospitalDAO extends PagingAndSortingRepository<Hospital, Long> {
	
	//通过医院名称删除医院
	@Modifying
	@Query("delete Hospital h where h.hospitalName = ?1")
	public int deleteByHospitalName(String name);
}
