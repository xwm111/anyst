package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Supplier;

/*
 * 供应商JPA操作接口
 */
public interface SupplierDAO extends PagingAndSortingRepository<Supplier, Long> {

}
