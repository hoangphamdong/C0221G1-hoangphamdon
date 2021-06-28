package com.example.model.repository;

import com.example.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {

    @Query(value = "select * from product where concat(`name`,price) like :keywordParam",nativeQuery = true)
    Page<Product>getProductBySearchingName(Pageable pageable, @Param("keywordParam")String keyword);
}
