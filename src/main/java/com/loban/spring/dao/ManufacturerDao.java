package com.loban.spring.dao;


import com.loban.spring.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerDao extends JpaRepository<Manufacturer, Long> {

    List<Manufacturer> findByName(String name);
}
