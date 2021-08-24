package com.enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrollment.entity.StaffLoginEntity;
import com.enrollment.exception.StaffIdNotFoundException;
import com.enrollment.service.StaffLoginService;



@RestController
@RequestMapping("/staffLogin")
public class StaffLoginController {

	@Autowired
	private StaffLoginService staffLoginService;
	
	
	@PostMapping("/addstaff/{id}/addLoginCredentials")
	public ResponseEntity<String> addLoginCredentials(@PathVariable("id") Long id,@RequestBody StaffLoginEntity staffLogin) throws StaffIdNotFoundException{
		
		ResponseEntity<String> s=staffLoginService.addLoginCredentials(id,staffLogin);
		if (s == null) {
			throw new StaffIdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Account is created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	
	}
	
	
	@PutMapping("/addstaff/{id}/addLoginCredentials/{userId}")
	public ResponseEntity<String> updateLoginCredentials(@PathVariable("id") Long id,@PathVariable("userId") Long userId,@RequestBody StaffLoginEntity staffLogin) throws StaffIdNotFoundException{
		
		ResponseEntity<String> s=staffLoginService.updateLoginCredentials(id,userId,staffLogin);
		if (s == null) {
			throw new StaffIdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Login Credentials is updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	
	}
}
	
	
	

