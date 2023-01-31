package com.sa.springbootrestdemo.dtos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sa.springbootrestdemo.controller.dto.MobilePhoneDto;
import com.sa.springbootrestdemo.entities.MobilePhone;


@Mapper
public interface MobileMapper {

	
//	@Mapping(source = "product.productId", target = "productId")//Source - Entity, target- Dto
//	@Mapping(source = "product.name", target = "name")
//	public ProductDto convertToDto(Product product); //Convert Entity to Dto
//	
//	
//	@Mapping(source = "productId", target = "productId")//Source - Dto, target - Entity
//	@Mapping(source = "name", target = "name")
//	public Product convertToEntity(ProductDto dto); //Convert Dto to Entity
	
	
	@Mapping(source="mobilePhone.mobileId",target="mobileId")//Source - Entity, target- Dto
	@Mapping(source="mobilePhone.brandName",target="brandName")
	@Mapping(source="mobilePhone.modelName",target="modelName")
	@Mapping(source="mobilePhone.color",target="color")
	
	
	
	public MobilePhoneDto convertToDto(MobilePhone mobilePhone);
	
	
	
}
