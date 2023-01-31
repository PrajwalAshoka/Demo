package com.sa.springbootrestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sa.springbootrestdemo.entities.MobilePhoneList;

@Repository
public interface MobilePhoneListRepository extends JpaRepository<MobilePhoneList, Long>{
	

}
