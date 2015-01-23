package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.LoginUser;

public interface LoginUserDAO extends
		PagingAndSortingRepository<LoginUser, Long> {

}
