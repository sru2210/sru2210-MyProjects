package com.enrollment.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.enrollment.entity.StaffAssignEntity;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.StaffIdNotFoundException;
import com.enrollment.service.StaffAssignService;


@RestController
@RequestMapping("/staffAssign")
public class StaffAssignController {
	@Autowired
	private StaffAssignService staffAssignServiceImpl;
	
	@PostMapping("/departmentInsertion/{deptId}/addStaffAssign")
	public ResponseEntity<String> addStaffAssign(@PathVariable("deptId") Long deptId,@RequestBody StaffAssignEntity staffAssign) throws DepartmentNotFoundException
	{
		StaffAssignEntity s=staffAssignServiceImpl.addStaffAssign(deptId,staffAssign);
		if(s==null)
			throw new DepartmentNotFoundException("Department Id is not found");
		else
			return new ResponseEntity<String>("Staff is assigned successfully", new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/departmentInsertion/{deptId}/getAllStaffsAssign")
	public List<StaffAssignEntity> getAllStaffsAssign(@PathVariable("deptId") Long deptId) throws DepartmentNotFoundException
	{
		List<StaffAssignEntity> staffAssignList=staffAssignServiceImpl.getAllStaffsAssign(deptId);
		return staffAssignList;
	}

	 @PutMapping("/departmentInsertion/{deptId}/addStaffAssign/{id}")
	 public ResponseEntity<String> updateStaffAssign(@PathVariable Long deptId,@PathVariable Long id,@Valid @RequestBody StaffAssignEntity staffAssign) throws DepartmentNotFoundException, StaffIdNotFoundException
	 {
		 ResponseEntity<String> s=staffAssignServiceImpl.updateStaffAssign(deptId,id,staffAssign);
			if(s==null)
				throw new DepartmentNotFoundException("Department Id or staffId  not found");
			else
				return new ResponseEntity<String>("Staff is updated successfully", new HttpHeaders(), HttpStatus.OK);

	 }

	 @DeleteMapping("/departmentInsertion/{deptId}/deleteStaffAssign/{id}")
		public ResponseEntity<String> deleteStaffAssign(@PathVariable("deptId") Long deptId,@PathVariable Long id,@Valid @RequestBody StaffAssignEntity staffAssign) throws DepartmentNotFoundException, StaffIdNotFoundException
		{
			
		 ResponseEntity<String> s=staffAssignServiceImpl.deleteStaffAssign(deptId,id,staffAssign);
			if(s==null)
				throw new DepartmentNotFoundException("Department Id or staffId  not found");
			else
				return new ResponseEntity<String>("Staff is deleted successfully", new HttpHeaders(), HttpStatus.OK);

		}
	 
	 
//	 @PutMapping("/students/{studentId}/assignments/{assignmentId}")
//	    public Assignment updateAssignment(@PathVariable Long studentId,
//	    								@PathVariable Long assignmentId,
//	    								@Valid @RequestBody Assignment assignmentUpdated) {
//	    	
//	    	if(!studentRepository.existsById(studentId)) {
//	    		throw new NotFoundException("Student not found!");
//	    	}
//	    	
//	        return assignmentRepository.findById(assignmentId)
//	                .map(assignment -> {
//	                    assignment.setName(assignmentUpdated.getName());
//	                    assignment.setGrade(assignmentUpdated.getGrade());
//	                    return assignmentRepository.save(assignment);
//	                }).orElseThrow(() -> new NotFoundException("Assignment not found!"));
//	    }
//	
}
