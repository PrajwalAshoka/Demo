package com.sa.springbootrestdemo.service;

import java.util.List;

import com.sa.springbootrestdemo.controller.dto.MobilePhoneDto;
import com.sa.springbootrestdemo.entities.Department;
import com.sa.springbootrestdemo.entities.MobilePhone;
import com.sa.springbootrestdemo.entities.MobilePhoneList;
import com.sa.springbootrestdemo.exception.MobileAlreadyExistException;
import com.sa.springbootrestdemo.exception.MobileListNotFoundException;
import com.sa.springbootrestdemo.exception.MobilePhoneNotExistException;

public interface MobilePhoneService {
	
	public List<MobilePhone> getAllMobiles() throws MobilePhoneNotExistException;
    
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobileAlreadyExistException;
	    
	public MobilePhone getMobilePhoneById(long id) throws MobilePhoneNotExistException;
	 
	public List<MobilePhone> getMobilePhoneByBrandName(String brandName) throws MobilePhoneNotExistException;    
	 
	public List<MobilePhone> getMobilePhoneByModelName(String modelName) throws MobilePhoneNotExistException;    
	    
	public void editMobilephone(MobilePhone mobilePhone) throws MobilePhoneNotExistException;
	    
	public String deleteMobilePhone(long id) throws MobilePhoneNotExistException;
	    
	public List<MobilePhoneDto> getAllMobilePhones() throws MobilePhoneNotExistException;
	 
	public MobilePhoneDto getMobilePhoneByIdDto(long id) throws MobilePhoneNotExistException;
	 
	public List<MobilePhoneDto> getMobilePhoneByBrandNameDto(String brandName) throws MobilePhoneNotExistException;    
	 
	public List<MobilePhoneDto> getMobilePhoneByModelNameDto(String modelName) throws MobilePhoneNotExistException;
	 
	public List<MobilePhone> getMobilePhone(double cost) throws MobilePhoneNotExistException; //get total number of mobile phones who having cost > 10K
	 
	public List<MobilePhone> getByProcessor(String processor) throws MobilePhoneNotExistException; //get Mobile Phone whose having processor with name - Quad Core
	 
	public List<MobilePhone> getByColor(String color) throws MobilePhoneNotExistException; //get Mobile Phone whose having color - black and blue
	 
	public int getMobilePhones(String modelName) throws MobilePhoneNotExistException; //get total number of mobile phone who are having unique model names
	 
	public MobilePhoneList saveMobilePhoneList(MobilePhoneList mobileList) throws MobileListNotFoundException;

	public MobilePhoneList addMobilePhoneToList(long mobilePhoneId, long mobileListId) throws MobilePhoneNotExistException, MobileListNotFoundException;

	public Department getDepartmentById(long id);
		
	
	
}
