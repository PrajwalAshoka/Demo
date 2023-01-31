package com.sa.springbootrestdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sa.springbootrestdemo.entities.Department;
import com.sa.springbootrestdemo.entities.MobilePhone;
import com.sa.springbootrestdemo.entities.MobilePhoneList;
import com.sa.springbootrestdemo.exception.MobileAlreadyExistException;
import com.sa.springbootrestdemo.exception.MobileListNotFoundException;
import com.sa.springbootrestdemo.exception.MobilePhoneNotExistException;
import com.sa.springbootrestdemo.service.MobilePhoneService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mobile")
public class MobilePhoneController {
	
	@Autowired
	private MobilePhoneService service;
	
	@PostMapping("/mobile/add")
	@Operation(summary = "To add a Product")
	public ResponseEntity<?> post(@RequestBody MobilePhone mp){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.saveMobilePhone(mp), HttpStatus.CREATED);
		} catch (MobileAlreadyExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/mobile/getByName/{brandName}")
	public ResponseEntity<?> getByName( @PathVariable(value="brandName") String brandName){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneByBrandName(brandName), HttpStatus.CREATED);
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
				
	}
	
	
	@GetMapping("/mobile/getAllPhone")
	public ResponseEntity<?> getAllPhone(){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getAllMobiles(), HttpStatus.CREATED);
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
				
	}
	
	@GetMapping("/mobile/getbyId/{id}")
	public ResponseEntity<?> getPhoneId(@PathVariable(value="id") long id){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneById(id), HttpStatus.CREATED);
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
				
	}
	
	@GetMapping("/mobile/dto/getAllPhonedto")
	public ResponseEntity<?> getAllPhoneDto(){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getAllMobilePhones(), HttpStatus.CREATED);
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
				
	}
	
	
	@GetMapping("/mobile/dto/getPhonedto/{id}")
	public ResponseEntity<?> getPhoneDtoById( @PathVariable(value="id") long id){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getMobilePhoneByIdDto(id), HttpStatus.CREATED);
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
				
	}
	
	
	
	
	@GetMapping("/mobile/name/getByProcessor/{processor}")
	public ResponseEntity<?> getbyProcessor(@PathVariable(value="processor") String processor){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getByProcessor(processor), HttpStatus.CREATED);
			return response;
		} catch(MobilePhoneNotExistException e) {
			response=new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		return response;
				
	}
	
	
	@GetMapping("/mobile/cost/{cost}")
	public ResponseEntity<?> getMobilePhoneByCost( double cost){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getMobilePhone(cost), HttpStatus.CREATED);
			return response;
		} catch(MobilePhoneNotExistException e) {
			response=new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			
		}
		
		return response;
				
	}
	
	@GetMapping("/mobile/name/modelname/{modelName}")
	@Operation(summary = "To get a Product by modelName")
	public ResponseEntity<?> getMobileByModelName( @PathVariable(value="modelName")  String modelName){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<List<MobilePhone>>(service.getMobilePhoneByModelName(modelName), HttpStatus.OK);
			return response;
		} catch(MobilePhoneNotExistException e) {
			response=new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			return response;
		}
		
		
				
	}
	
	
	@GetMapping("/mobile/name/getBycolor{color}")
	
	public ResponseEntity<?> getbycolor( @PathVariable(value="color") String color){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getByColor(color), HttpStatus.CREATED);
		} catch(MobilePhoneNotExistException e) {
			response=new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			return response;
		}
		
		
		return response;
				
	}
	
	
	@GetMapping("/mobile/name/getByName/{modelName}")
	public ResponseEntity<?> getbyModelName(@PathVariable(value="modelName") String modelName){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<List<MobilePhone>>(service.getMobilePhoneByModelName(modelName), HttpStatus.CREATED);
			return response;
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;
				
	}
	
	@PutMapping("/mobile/putById")
	public void put(@RequestBody MobilePhone mobilePhone){
		ResponseEntity<?> response = null;
		try {
			service.editMobilephone(mobilePhone);
			System.out.println("updated sucessfully");
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			
		}
		
	}
	
//	@PostMapping("/mobilelist/add")
//	@Operation(summary = "To add a Product")
//	public ResponseEntity<?> postlist(@RequestBody MobilePhoneList mobilePhoneList){
//		ResponseEntity<?> response = null;
//		try {
//			response = new ResponseEntity<>(service.saveMobilePhoneList(mobilePhoneList), HttpStatus.CREATED);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return response;
//	}
	
	@DeleteMapping("/mobilePhone/delete/{id}")
	public void delete( @PathVariable(value="id") long id){
		ResponseEntity<?> response = null;
		try {
			response= new ResponseEntity<>(service.deleteMobilePhone(id), HttpStatus.OK);
			System.out.println("updated sucessfully");
		} catch (MobilePhoneNotExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/mobilesDto/{brandName}")
	public ResponseEntity<?>getPoductDtoByBrandName(@PathVariable(value="brandName") String brandName){
		ResponseEntity<?>response=null;
		try {
			 response=new ResponseEntity<>(service.getMobilePhoneByBrandNameDto(brandName), HttpStatus.OK);
			 return response;
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	
	@GetMapping("/mobilesDto/name/{modelName}")
	public ResponseEntity<?>getPoductDtoBymodelName(@PathVariable(value="modelName") String modelName){
		ResponseEntity<?>response=null;
		try {
			 response=new ResponseEntity<>(service.getMobilePhoneByModelNameDto(modelName), HttpStatus.OK);
			 return response;
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	
	@PostMapping("/mobileList/add")
	public ResponseEntity<?> addMobileList(@RequestBody MobilePhoneList mobilePhoneList){
		ResponseEntity<?>response=null;
		try {
			 response=new ResponseEntity<>(service.saveMobilePhoneList(mobilePhoneList), HttpStatus.OK);
			 return response;
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	@PostMapping("/mobilephone/addmobiletolist/{mobilePhoneId}/{mobileListId}")
    @Operation(summary="To add a mobile pohne list")
    public ResponseEntity<?>addMobileToList(@PathVariable (value="mobilePhoneId")long mobilePhoneId,@PathVariable(value="mobileListId")long mobileListId){
        ResponseEntity<?>response=null;

        try {
            response=new ResponseEntity<MobilePhoneList>(service.addMobilePhoneToList(mobilePhoneId, mobileListId),HttpStatus.CREATED);
        } catch (MobilePhoneNotExistException e) {

            response=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

        } catch (MobileListNotFoundException e) {
            response=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

        return response;

    }
	
	@GetMapping("/departmentById/{id}")
	public ResponseEntity<?> getDepartment(@PathVariable(value="id")long id){
		ResponseEntity<?> response =null;
		response=new ResponseEntity<Department>(service.getDepartmentById(id),HttpStatus.CREATED);
		return response;
	}
	
	
}
