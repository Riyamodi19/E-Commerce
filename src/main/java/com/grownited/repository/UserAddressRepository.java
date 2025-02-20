package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.UserAddressEntity;

public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Integer> {

}
