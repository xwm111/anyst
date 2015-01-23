package cn.wh.anyst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.wh.anyst.entity.Product;

public interface ProductDAO extends PagingAndSortingRepository<Product, Long> {

}
