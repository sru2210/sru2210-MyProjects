package com.enrollment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.enrollment.entity.StaffEntity;
import com.enrollment.entity.StaffLoginEntity;
import com.enrollment.exception.StaffIdNotFoundException;


public interface StaffService {

	StaffEntity addStaff(long id,StaffEntity staff) throws StaffIdNotFoundException;
	StaffEntity getStaffById(long id);
	List<StaffEntity> getAllStaff();
	ResponseEntity<String> updateStaff(long id,StaffEntity staffLoginEntity) throws StaffIdNotFoundException;
	StaffEntity deleteStaff(long id);
}
