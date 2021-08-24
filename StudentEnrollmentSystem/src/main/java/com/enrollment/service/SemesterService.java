package com.enrollment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.enrollment.entity.SemesterEntity;
import com.enrollment.exception.SemesterNotFoundException;

public interface SemesterService {
	ResponseEntity<String> addSemesterDetails(SemesterEntity semesterDetails);
	ResponseEntity<String> updateSemesterDetails(Long semId,SemesterEntity semDetails) throws SemesterNotFoundException;
	List<SemesterEntity> getSemesterDetails();
	ResponseEntity<SemesterEntity> getParticularSemesterDetails(Long semId) throws SemesterNotFoundException;
}
