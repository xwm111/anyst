package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.LoginUser;

/*
 * 用户登陆JPA操作接口
 */
public interface LoginUserDAO extends
		PagingAndSortingRepository<LoginUser, Long> {

}
