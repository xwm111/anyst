package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Logs;

public interface LogsDAO extends PagingAndSortingRepository<Logs, Long> {

}
