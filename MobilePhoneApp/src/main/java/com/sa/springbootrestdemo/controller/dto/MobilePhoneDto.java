package com.sa.springbootrestdemo.controller.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobilePhoneDto {
	
	private long mobileId;
	private String brandName;
	private String modelName;
	private String color;
	
}
