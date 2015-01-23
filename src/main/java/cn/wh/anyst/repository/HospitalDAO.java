package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Hospital;

public interface HospitalDAO extends PagingAndSortingRepository<Hospital, Long> {

}
