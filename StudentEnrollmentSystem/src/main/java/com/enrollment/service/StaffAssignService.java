package com.enrollment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.enrollment.entity.StaffAssignEntity;
import com.enrollment.entity.StaffEntity;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.StaffIdNotFoundException;



public interface StaffAssignService {
	StaffAssignEntity addStaffAssign(Long deptId,StaffAssignEntity staffAssign) throws DepartmentNotFoundException;
	List<StaffAssignEntity> getAllStaffsAssign(Long deptId) throws DepartmentNotFoundException;
	//List<StaffAssignEntity> getAllStaffsAssign();
	
	ResponseEntity<String> updateStaffAssign(long deptId,long id,StaffAssignEntity staffAssign) throws DepartmentNotFoundException, StaffIdNotFoundException;
	
	ResponseEntity<String> deleteStaffAssign(long deptId,long id,StaffAssignEntity staffAssign) throws DepartmentNotFoundException, StaffIdNotFoundException;
	
	
}
