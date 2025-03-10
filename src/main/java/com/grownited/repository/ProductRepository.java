package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
        
	  @Query(value = " select p.* ,c.category_name, sb.sub_category_name from product p, category c, subcategory sb where p.category_id = c.category_id and p.sub_category_id = sb.sub_category_id;", nativeQuery = true)
	  List<Object[]>getAll();
}
