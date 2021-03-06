package com.loban.spring.dao;


import com.loban.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findByNameProduct(String nameProduct);
}
