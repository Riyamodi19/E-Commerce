package com.grownited.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.UserAddressEntity;
@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Integer> {
	       
	   @Query(value = "select ua.*, u.first_name , u.last_name , c.city_name , s.state_name from useraddress ua, users u, city c, state s where ua.user_id = u.user_id and ua.city_id = c.city_id and ua.state_id = s.state_id",nativeQuery = true)
	     List<Object[]> getAll();
	     
	  @Query(value = "select ua.*, u.first_name , u.last_name , c.city_name , s.state_name from useraddress ua, users u, city c, state s where ua.user_id = u.user_id and ua.city_id = c.city_id and ua.state_id = s.state_id and ua.user_address_id = :userAddressId",nativeQuery = true)
	     List<Object[]>getByUserAddressId(Integer userAddressId);
}


