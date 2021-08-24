package com.enrollment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enrollment.entity.SemesterEntity;
import com.enrollment.exception.SemesterNotFoundException;
import com.enrollment.service.SemesterService;

@RestController
@RequestMapping("/semester")
public class SemesterController {
	@Autowired
	private SemesterService semesterServiceImpl;
	@PostMapping("/semesterInsertion")
	public ResponseEntity<String> addSemesterDetails(@RequestBody SemesterEntity semesterDetails)
	{
		return semesterServiceImpl.addSemesterDetails(semesterDetails);
	}
	@PutMapping("/semUpdation/{semId}")
	public ResponseEntity<String> updateSemesterDetails(@PathVariable("semId") Long semId,@RequestBody SemesterEntity semDetails) throws SemesterNotFoundException
	{
		return semesterServiceImpl.updateSemesterDetails(semId,semDetails);
	}
	@GetMapping("/getSemDetails")
	public ResponseEntity<List<SemesterEntity>> getSemesterDetails()
	{
		List<SemesterEntity> semesterList=semesterServiceImpl.getSemesterDetails();
		if(semesterList.isEmpty())
		{
			System.out.println("No Semester Found!");
		}
		return new ResponseEntity<List<SemesterEntity>>(semesterList,new HttpHeaders(),HttpStatus.OK);
	}
	@GetMapping("/getParticularSemDetails/{semId}")
	public ResponseEntity<SemesterEntity> getParticularSemesterDetails(@PathVariable("semId") long semId) throws SemesterNotFoundException
	{
		return semesterServiceImpl.getParticularSemesterDetails(semId);
	}
}
