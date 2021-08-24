package com.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enrollment.entity.StaffAssignEntity;
import com.enrollment.entity.StaffEntity;
import com.enrollment.entity.StaffLoginEntity;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.StaffIdNotFoundException;
import com.enrollment.repository.StaffAssignRepository;
import com.enrollment.repository.StaffRepository;


@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	StaffAssignRepository staffAssignRepository;
	
	@Override
	public StaffEntity addStaff(long id,StaffEntity staff) throws StaffIdNotFoundException {
		
		return staffAssignRepository.findById(id)
				.map(s->{
					staff.setStaffId(s);
				return staffRepository.save(staff);
				}).orElseThrow(()->new StaffIdNotFoundException("StaffId is not found, Enter valid Id"));
     
		
	}

	@Override
	public StaffEntity getStaffById(long id) {
		
		return staffRepository.findById(id).get();
	}

	@Override
	public List<StaffEntity> getAllStaff() {
		
		return staffRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateStaff(long id, StaffEntity staffEntity) throws StaffIdNotFoundException {
	
	return staffRepository.findById(id).
			map(staff->{
				staff.setFirstName(staffEntity.getFirstName());
				staff.setLastName(staffEntity.getLastName());
				staff.setDateOfBirth(staffEntity.getDateOfBirth());
				staff.setGender(staffEntity.getGender());
				staff.setQualification(staffEntity.getQualification());
				staff.setEmail(staffEntity.getEmail());
				staff.setContactNo(staffEntity.getContactNo());
				staff.setAddress(staffEntity.getAddress());
				staffRepository.save(staff);
	return new ResponseEntity<String>("Staff Details updated successfully!",new HttpHeaders(),HttpStatus.OK);
	}).orElseThrow(()->new StaffIdNotFoundException("Staff not found with the ID"+" "+id));
	}

	@Override
	public StaffEntity deleteStaff(long id) {
		StaffEntity s=staffRepository.findById(id).get();
		if(s !=null)
			staffRepository.deleteById(id);
			return s; 
	}

}
