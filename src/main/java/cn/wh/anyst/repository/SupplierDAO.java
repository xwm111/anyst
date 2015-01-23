package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Supplier;

public interface SupplierDAO extends PagingAndSortingRepository<Supplier, Long> {

}
