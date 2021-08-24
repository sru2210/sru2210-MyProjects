package com.enrollment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enrollment.entity.StaffAssignEntity;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.StaffIdNotFoundException;
import com.enrollment.repository.DepartmentRepository;
import com.enrollment.repository.StaffAssignRepository;
import com.enrollment.repository.StaffRepository;


@Service
public class StaffAssignServiceImpl implements StaffAssignService{

	@Autowired
	private StaffAssignRepository staffAssignRepository;
	@Autowired
	private DepartmentRepository deptRepository;
	
	public StaffAssignEntity addStaffAssign(Long deptId,StaffAssignEntity staffAssign) throws DepartmentNotFoundException {
		
		return deptRepository.findById(deptId)
				.map(dept->{
					staffAssign.setDept(dept);
				return staffAssignRepository.save(staffAssign);
				}).orElseThrow(()->new DepartmentNotFoundException("Department is not found, Enter valid Id"));
               
	}

	public List<StaffAssignEntity> getAllStaffsAssign(Long deptId) throws DepartmentNotFoundException {
		
		if(!deptRepository.existsById(deptId))
		{
			 throw new DepartmentNotFoundException("Department not found!");
		}
		
	    	return staffAssignRepository.findByDeptId(deptId);
	}

	@Override
	public ResponseEntity<String> updateStaffAssign(long deptId, long id, StaffAssignEntity staffAssign)
			throws DepartmentNotFoundException, StaffIdNotFoundException {
		
		if(!deptRepository.existsById(deptId))
			throw new DepartmentNotFoundException("Department Not Found,Enter the valid ID!");
		return staffAssignRepository.findById(id)
				.map(staff->{
					
					staff.setId(staffAssign.getId());
					staff.setJoiningDate(staffAssign.getJoiningDate());
					staff.setName(staffAssign.getName());
					staffAssignRepository.save(staff);
					return new ResponseEntity<String>("Staff Assigned Details Updated Successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElseThrow(()->new DepartmentNotFoundException("Staff Not Found,Enter the valid ID!"));
	
	}

	@Override
	public ResponseEntity<String> deleteStaffAssign(long deptId, long id, StaffAssignEntity staffAssign)
			throws DepartmentNotFoundException, StaffIdNotFoundException {
		if(!deptRepository.existsById(deptId))
			throw new DepartmentNotFoundException("Department Not Found,Enter the valid ID!");
		return staffAssignRepository.findById(id)
				.map(staff->{
					staffAssignRepository.delete(staff);
					return new ResponseEntity<String>("Staff Assigned Details is deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElseThrow(()->new DepartmentNotFoundException("Staff Not Found,Enter the valid ID!"));
	
	}
	}





