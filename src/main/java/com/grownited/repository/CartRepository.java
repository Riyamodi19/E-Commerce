package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
    @Query(value = " select c.* ,p.product_name, u.first_name, u.last_name from cart c, users u, product p where c.product_id = p.product_id and c.user_id = u.user_id;", nativeQuery = true)
    List<Object[]>getAll();
}
