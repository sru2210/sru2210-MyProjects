package com.enrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.enrollment.entity.StaffAssignEntity;
import com.enrollment.entity.StaffEntity;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.StaffIdNotFoundException;
import com.enrollment.service.StaffService;
import com.enrollment.service.StaffServiceImpl;



@RestController
@RequestMapping("/staffs")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	
	@PostMapping("/addStaffAssign/{id}/addstaff")
	public ResponseEntity<String> addStaff(@PathVariable("id") long id,@RequestBody StaffEntity staff) throws StaffIdNotFoundException{
		
		StaffEntity s=staffService.addStaff(id,staff);
		if (s == null) {
			throw new StaffIdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Staff is added successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	

	
	@GetMapping("/addStaffAssign/getAllStaffs")
	private ResponseEntity<List<StaffEntity>> getAllStaff() {
		List<StaffEntity> stafflist = staffService.getAllStaff();
		return new ResponseEntity<List<StaffEntity>>(stafflist, new HttpHeaders(), HttpStatus.OK);

	}
	
	@PutMapping("/addStaffAssign/updateStaff/{id}")
	public ResponseEntity<String> updateStaff(@PathVariable("id") long id,@RequestBody StaffEntity staffEntity)throws StaffIdNotFoundException
	{
		
	return staffService.updateStaff(id,staffEntity);
	}
	
	@DeleteMapping("/DeleteStaff/{id}")
	private ResponseEntity<String> deleteStaff(@PathVariable("id") long id) throws StaffIdNotFoundException {
		StaffEntity s = staffService.deleteStaff(id);
		if (s == null) {
			throw new StaffIdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("staff deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
}
