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

import com.enrollment.entity.DepartmentEntity;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentServiceImpl;
	@PostMapping("/departmentInsertion")
	public ResponseEntity<String> addDepartmentDetails(@RequestBody DepartmentEntity departmentDetails)
	{
		return departmentServiceImpl.addDepartmentDetails(departmentDetails);
	}
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<DepartmentEntity>> getDepartmentDetails()
	{
		List<DepartmentEntity> allDepartmentDetailsList=departmentServiceImpl.getDepartmentDetails();
		return new ResponseEntity<List<DepartmentEntity>>(allDepartmentDetailsList,new HttpHeaders(),HttpStatus.OK);
	}
	@GetMapping("/getParticularDeptDetails/{id}")
	public ResponseEntity<DepartmentEntity> getParticularDepartmentDetails(@PathVariable("id") Long deptId) throws DepartmentNotFoundException
	{
		return departmentServiceImpl.getParticularDepartmentDetails(deptId);
	}
	@DeleteMapping("/departmentDeletion/{id}")
	public ResponseEntity<String> deleteDepartmentDetails(@PathVariable("id") Long deptId) throws DepartmentNotFoundException
	{
		return departmentServiceImpl.deleteDepartmentDetails(deptId);
	}
	@PutMapping("/departmentUpdation/{deptId}")
	public ResponseEntity<String> updateDepartmentDetails(@PathVariable("deptId") Long deptId,@RequestBody DepartmentEntity departmentDetails) throws DepartmentNotFoundException
	{
		return departmentServiceImpl.updateDepartmentDetails(deptId,departmentDetails);
	}
}
