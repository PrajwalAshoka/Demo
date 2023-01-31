package com.sa.springbootrestdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sa.springbootrestdemo.controller.dto.MobilePhoneDto;
import com.sa.springbootrestdemo.dtos.MobileMapper;
import com.sa.springbootrestdemo.entities.Department;
import com.sa.springbootrestdemo.entities.MobilePhone;
import com.sa.springbootrestdemo.entities.MobilePhoneList;
import com.sa.springbootrestdemo.exception.MobileAlreadyExistException;
import com.sa.springbootrestdemo.exception.MobileListNotFoundException;
import com.sa.springbootrestdemo.exception.MobilePhoneNotExistException;
import com.sa.springbootrestdemo.repository.MobilePhoneListRepository;
import com.sa.springbootrestdemo.repository.MobilePhoneRepository;
import com.sa.springbootrestdemo.service.MobilePhoneService;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService{

	@Autowired
	private MobilePhoneRepository mobileRepo;
	
	@Autowired
	private MobilePhoneListRepository mobileListRepo;

	@Autowired
	private MobileMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public List<MobilePhone> getAllMobiles() throws MobilePhoneNotExistException {
		List<MobilePhone>mobilePhoneList=null;
		mobilePhoneList=mobileRepo.findAll();
		if(mobilePhoneList.size()==0)
			throw new MobilePhoneNotExistException("Mobile Phone in this Db not Exist");
		return mobilePhoneList;
	}

	@Override
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobileAlreadyExistException {
		MobilePhone mob=null;
		if(mobileRepo.existsById( mobilePhone.getMobileId()))
			throw new MobileAlreadyExistException("Mobile already exist ");
			
		mob=mobileRepo.save(mobilePhone);
		return mob;
	}

	@Override
	public MobilePhone getMobilePhoneById(long id) throws MobilePhoneNotExistException {
		MobilePhone mobilePhone=null;
		mobilePhone=mobileRepo.findById(id).orElseThrow(() -> new MobilePhoneNotExistException("Mobile does not exist with this id"));
		return mobilePhone;
	}

	@Override
	public List<MobilePhone> getMobilePhoneByBrandName(String brandName) throws MobilePhoneNotExistException {
		List<MobilePhone> mobilePhone=null;
		mobilePhone=mobileRepo.findByName(brandName);
		if(mobilePhone.size()==0)
			throw new MobilePhoneNotExistException("Mobile does not exist with this Brand Name");
		
		return mobilePhone;
	}

	@Override
	public List<MobilePhone> getMobilePhoneByModelName(String modelName) throws MobilePhoneNotExistException {
		List<MobilePhone>mobileList=null;
		mobileList=mobileRepo.findByModelName(modelName);
		if(mobileList.size()==0) {
			throw new MobilePhoneNotExistException("Mobile does not exist with this model name");
		}
		
	
		return mobileList;
	}

	@Override
	public void editMobilephone(MobilePhone mobilePhone) throws MobilePhoneNotExistException {
		int mob=0;
		
		if(!mobileRepo.existsById(mobilePhone.getMobileId()))
			throw new MobilePhoneNotExistException("Mobile does not exist with this id");
		
		mobileRepo.save(mobilePhone);
		
	}

	@Override
	public String deleteMobilePhone(long id) throws MobilePhoneNotExistException {
		MobilePhone mobilePhone=null;
		
		if(mobileRepo.findById(id)==null) {
			throw new MobilePhoneNotExistException("Mobile does not exist with this id");
		}
		mobileRepo.deleteById(id);
		return null;
	}

	@Override
	public List<MobilePhoneDto> getAllMobilePhones() throws MobilePhoneNotExistException {
		
		List<MobilePhone>mobilePhones=null;
		mobilePhones=mobileRepo.findAll();
		if(mobilePhones.size()==0)
			throw new MobilePhoneNotExistException("Mobile does not exist in  DB");
		List<MobilePhoneDto>mobileDtoListPhones=new ArrayList<>();
		MobilePhoneDto mobiledto=null;
		for(MobilePhone i:mobilePhones) {
			mobiledto=mapper.convertToDto(i);
			mobileDtoListPhones.add(mobiledto);
		}
		
		return mobileDtoListPhones;
	}

	@Override
	public MobilePhoneDto getMobilePhoneByIdDto(long id) throws MobilePhoneNotExistException {
		MobilePhone mobilePhone =null;
		mobilePhone=mobileRepo.findById(id).orElseThrow(() -> new MobilePhoneNotExistException("Mobile does not exist with this id"));
		MobilePhoneDto mobilePhoneDto=null;
		mobilePhoneDto=mapper.convertToDto(mobilePhone);
		return mobilePhoneDto;
	}

	@Override
	public List<MobilePhoneDto> getMobilePhoneByBrandNameDto(String brandName) throws MobilePhoneNotExistException {
		List<MobilePhone>mobilePhoneList=null;
		mobilePhoneList=mobileRepo.findByName(brandName);
		if(mobilePhoneList.size()==0)
			throw new MobilePhoneNotExistException("Mobile Phone with this Brand name do not exist");
		List<MobilePhoneDto>mobilePhoneDtolist=new ArrayList<>();
		MobilePhoneDto mobilePhoneDto=null;
		for(MobilePhone i:mobilePhoneList) {
			mobilePhoneDto=mapper.convertToDto(i);
			mobilePhoneDtolist.add(mobilePhoneDto);
		}
		return mobilePhoneDtolist;
	}

	@Override
	public List<MobilePhoneDto> getMobilePhoneByModelNameDto(String modelName) throws MobilePhoneNotExistException {
		List<MobilePhone>mobilePhoneList=null;
		mobilePhoneList=mobileRepo.findByModelName(modelName);
		if(mobilePhoneList.size()==0)
			throw new MobilePhoneNotExistException("Mobile Phone with this Brand name do not exist");
		List<MobilePhoneDto>mobilePhoneDtolist=new ArrayList<>();
		MobilePhoneDto mobilePhoneDto=null;
		for(MobilePhone i:mobilePhoneList) {
			mobilePhoneDto=mapper.convertToDto(i);
			mobilePhoneDtolist.add(mobilePhoneDto);
		}
		return mobilePhoneDtolist;
	}

	@Override
	public List<MobilePhone> getMobilePhone(double cost) throws MobilePhoneNotExistException {
		List<MobilePhone> mobilePhone=null;
		mobilePhone=mobileRepo.totalNoOfMobiles(cost);
		if(mobilePhone.size()==0)
			throw new MobilePhoneNotExistException("Mobile Phone with this cost do not exist");
		return mobilePhone;
	}

	@Override
	public List<MobilePhone> getByProcessor(String processor) throws MobilePhoneNotExistException {
		List<MobilePhone>mobilePhone=null;
		mobilePhone=mobileRepo.getByProcessor(processor);
		if(mobilePhone.size()==0)
			throw new MobilePhoneNotExistException("Mobile phone not exist");
		
		return mobilePhone;
	}

	@Override
	public List<MobilePhone> getByColor(String color) throws MobilePhoneNotExistException  {
		List<MobilePhone>mobilePhone=null;
		mobilePhone=mobileRepo.getByColor(color);
		if(mobilePhone.size()==0) {
			throw new MobilePhoneNotExistException("Mobile phone not exists");
		}
		return mobilePhone;
	}

	@Override
	public int getMobilePhones(String modelName) throws MobilePhoneNotExistException {
		List<MobilePhone>mobilePhone=null;

		mobilePhone=mobileRepo.getbyModelNames(modelName);
		if(mobilePhone.size()==0)
			throw new MobilePhoneNotExistException("Mobile phone not exist");
		
		return mobilePhone.size();	
	}

	@Override
	public MobilePhoneList saveMobilePhoneList(MobilePhoneList mobileList) throws MobileListNotFoundException {
		
		MobilePhoneList mobileList1 =null;
		mobileList1=  mobileListRepo.findById(mobileList.getListId()).get();
		if(mobileList1== null)
			throw new MobileListNotFoundException("Mobile Phone list Not found");
		mobileListRepo.save(mobileList);
		
		return mobileList;
	}
	
	@Override
	public MobilePhoneList addMobilePhoneToList(long mobilePhoneId, long mobilePhoneListId) throws MobilePhoneNotExistException, MobileListNotFoundException {
        MobilePhone mobileFromDb=mobileRepo.findById(mobilePhoneId).orElseThrow(() -> new MobilePhoneNotExistException("Mobile does not exist with this id"));;
        MobilePhoneList mobilePhoneList=mobileListRepo.findById(mobilePhoneListId).get();
        if(mobilePhoneList==null)
            throw new MobileListNotFoundException("list given id does not exist");
        
        mobilePhoneList.getMobileList().add(mobileFromDb);
        mobileListRepo.save(mobilePhoneList);

        return mobilePhoneList;
    }

	@Override
	public Department getDepartmentById(long id) {
		ResponseEntity<Department> response=restTemplate.getForEntity("http://localhost:8099//petzeydepartment//department/departmentbyid/"+id, Department.class);
		
		Department department = response.getBody();
		return department;
	}

}
