package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.grownited.dto.UserAddressDto;
import com.grownited.entity.UserAddressEntity;

public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Integer> {
	   
	 @Query(value  = "select c.*,s.state_name from state s,city c where s.state_id = c.state_id",nativeQuery = true)
     List<UserAddressDto> getAll();

}
