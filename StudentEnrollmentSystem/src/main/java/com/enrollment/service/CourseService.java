package com.enrollment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.enrollment.entity.CourseEntity;
import com.enrollment.exception.CourseCodeNotFoundException;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.SemesterNotFoundException;

public interface CourseService {
	ResponseEntity<String> addCourseDetails(Long semId,Long deptId,CourseEntity courseDetails);
	ResponseEntity<String> updateCourseDetails(String courseCode,CourseEntity courseDetails) throws CourseCodeNotFoundException;
	ResponseEntity<String> deleteCourseDetails(String courseCode)throws CourseCodeNotFoundException;
	List<CourseEntity> getCourseDetailsBySemId(Long semId) throws SemesterNotFoundException;
	List<CourseEntity> getCourseDetailsByDeptId(Long deptId) throws DepartmentNotFoundException;
}
