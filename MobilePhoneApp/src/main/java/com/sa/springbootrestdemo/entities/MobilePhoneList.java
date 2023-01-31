package com.sa.springbootrestdemo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Default Constructor
@AllArgsConstructor //Parameterized Constructor
@Data //Getter and setter methods
@Entity //Maps as a table in DB
public class MobilePhoneList {
	@Id
	private long listId;
	private String listName;
	
	@OneToMany
	@JoinColumn
	List<MobilePhone>mobileList;

}
