package com.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enrollment.entity.SemesterEntity;
import com.enrollment.exception.SemesterNotFoundException;
import com.enrollment.repository.SemesterRepository;
@Service
public class SemesterServiceImpl implements SemesterService{
	@Autowired
	private SemesterRepository semesterRepository;
	@Override
	public ResponseEntity<String> addSemesterDetails(SemesterEntity semesterDetails) {
		// TODO Auto-generated method stub
		semesterRepository.save(semesterDetails);
		return new ResponseEntity<String>("Semester Details added successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	@Override
	public ResponseEntity<String> updateSemesterDetails(Long semId, SemesterEntity semDetails) throws SemesterNotFoundException {
		// TODO Auto-generated method stub
		return semesterRepository.findById(semId)
				.map(semester->{
					semester.setBeginDate(semDetails.getBeginDate());
					semester.setEndDate(semDetails.getEndDate());
					semesterRepository.save(semester);
					return new ResponseEntity<String>("Semester details updated successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElseThrow(()->new SemesterNotFoundException("Semester Not Found!"));
	}
	@Override
	public List<SemesterEntity> getSemesterDetails() {
		// TODO Auto-generated method stub
		return semesterRepository.findAll();
	}
	@Override
	public ResponseEntity<SemesterEntity> getParticularSemesterDetails(Long semId) throws SemesterNotFoundException {
		// TODO Auto-generated method stub
		if(!semesterRepository.existsById(semId))
		{
			throw new SemesterNotFoundException("Semester Not Found!");
		}
		SemesterEntity semEntity=semesterRepository.findById(semId).get();
		return new ResponseEntity<SemesterEntity>(semEntity,new HttpHeaders(),HttpStatus.OK);
	}

}
