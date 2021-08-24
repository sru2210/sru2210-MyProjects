package com.enrollment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.enrollment.entity.DepartmentEntity;
import com.enrollment.exception.DepartmentNotFoundException;

public interface DepartmentService{
	ResponseEntity<String> addDepartmentDetails(DepartmentEntity departmentDetails);
	List<DepartmentEntity> getDepartmentDetails();
	ResponseEntity<DepartmentEntity> getParticularDepartmentDetails(Long deptId) throws DepartmentNotFoundException;
	ResponseEntity<String> deleteDepartmentDetails(long deptId) throws DepartmentNotFoundException;
	ResponseEntity<String> updateDepartmentDetails(Long deptId,DepartmentEntity departmentDetails) throws DepartmentNotFoundException;
}
