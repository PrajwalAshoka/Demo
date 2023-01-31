package com.sa.springbootrestdemo.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sa.springbootrestdemo.entities.MobilePhone;

@Transactional
@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Long>{

	
	@Query(value="select m from MobilePhone m where m.brandName=:brandName")
	public List<MobilePhone> findByName(@Param (value = "brandName")   String brandName);

	
	@Query(value="select m from MobilePhone m where m.modelName=:modelName")
	public List<MobilePhone> findByModelName(@Param(value="modelName") String modelName);


		
	@Query(value="select m from MobilePhone m where m.mobilePhoneCost=:cost")
	public List<MobilePhone> totalNoOfMobiles( @Param(value="cost") double cost);


	@Query(value="select m from MobilePhone m where m.processor=:processor")
	public List<MobilePhone> getByProcessor(String processor);

	@Query(value="select m from MobilePhone m where m.color=:color")
	public List<MobilePhone> getByColor(String color);

	
	@Query(value="select count(m) from MobilePhone m where m.modelName=:modelName")
	public List<MobilePhone> getbyModelNames(String modelName);

//	@Modifying
//	@Query(value="update MobilePhone m set m.brandName=:brandName, where m.mobileId=:id")
//	public int editPhone(@Param(value="brandName")String brandName,@Param(value="id") long id);
	

	//in built methods or Query - SQL/HQL/JPQL
	
//	@Query(value = "select p from Product p") //HQL/JPQL
	//Or
//	@Query(value = "select * from product", nativeQuery = true) //SQL
//	public List<Mobilephone> getProducts();
	
//	@Query(value = "select * from product p where p.product_id=id", nativeQuery = true)
	//Or
//	@Query(value = "select p from Product p where p.productId=:id")
//	public Product getProductById(@Param (value = "id") long id);
	
	
}
