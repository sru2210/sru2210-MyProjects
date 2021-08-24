package com.enrollment.service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.enrollment.entity.StaffEntity;
import com.enrollment.entity.StaffLoginEntity;
import com.enrollment.exception.StaffIdNotFoundException;

public interface StaffLoginService {

public ResponseEntity<String> addLoginCredentials( Long id,StaffLoginEntity staff) throws StaffIdNotFoundException;
	
public ResponseEntity<String> updateLoginCredentials(Long id,Long userId, StaffLoginEntity staff) throws StaffIdNotFoundException;


		
}
