package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Logs;

/*
 * 日志JPA操作接口
 */
public interface LogsDAO extends PagingAndSortingRepository<Logs, Long> {

}
