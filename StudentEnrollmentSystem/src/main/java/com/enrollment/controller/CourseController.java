package com.enrollment.controller;

import java.util.List;

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

import com.enrollment.entity.CourseEntity;
import com.enrollment.exception.CourseCodeNotFoundException;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.SemesterNotFoundException;
import com.enrollment.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseServiceImpl;
	@PostMapping("/semester/{semId}/department/{deptId}/courseInsertion")
	public ResponseEntity<String> addCourseDetails(@PathVariable("semId") Long semId,@PathVariable("deptId") Long deptId,@RequestBody CourseEntity courseDetails)
	{
		return courseServiceImpl.addCourseDetails(semId,deptId,courseDetails);
	}
	@PutMapping("/courseUpdation/{code}")
	public ResponseEntity<String> updateCourseDetails(@PathVariable("code") String code,@RequestBody CourseEntity courseDetails) throws CourseCodeNotFoundException
	{
		return courseServiceImpl.updateCourseDetails(code,courseDetails);
	}
	@DeleteMapping("/courseDeletion/{code}")
	public ResponseEntity<String> deleteCourseDetails(@PathVariable("code") String code) throws CourseCodeNotFoundException
	{
		return courseServiceImpl.deleteCourseDetails(code);
	}
	@GetMapping("/semester/{semId}/getBySemesterId")
	public ResponseEntity<List<CourseEntity>> getCourseDetailsBySemId(@PathVariable("semId") Long semId) throws SemesterNotFoundException
	{
		List<CourseEntity> courseDetails=courseServiceImpl.getCourseDetailsBySemId(semId);
		return new ResponseEntity<List<CourseEntity>>(courseDetails,new HttpHeaders(),HttpStatus.OK);
	}
	@GetMapping("/department/{deptId}/getByDeptId")
	public ResponseEntity<List<CourseEntity>> getCourseDetailsByDeptId(@PathVariable("deptId") Long deptId) throws DepartmentNotFoundException
	{
		List<CourseEntity> courseDetails=courseServiceImpl.getCourseDetailsByDeptId(deptId);
		return new ResponseEntity<List<CourseEntity>>(courseDetails,new HttpHeaders(),HttpStatus.OK);
	}
}
