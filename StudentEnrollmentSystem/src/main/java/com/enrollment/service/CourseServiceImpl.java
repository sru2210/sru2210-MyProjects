package com.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enrollment.entity.CourseEntity;
import com.enrollment.entity.DepartmentEntity;
import com.enrollment.entity.SemesterEntity;
import com.enrollment.exception.CourseCodeNotFoundException;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.exception.SemesterNotFoundException;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.DepartmentRepository;
import com.enrollment.repository.SemesterRepository;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private SemesterRepository semesterRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Override
	public ResponseEntity<String> addCourseDetails(Long semId, Long deptId, CourseEntity courseDetails) {
		// TODO Auto-generated method stub
		/*if(!semesterRepository.existsById(deptId))
		{
			return new ResponseEntity<String>("Semester Not Found!Enter the valid id",new HttpHeaders(),HttpStatus.OK);
		}
		if(!departmentRepository.existsById(deptId))
		{
			return new ResponseEntity<String>("Department Not Found!Enter the valid id",new HttpHeaders(),HttpStatus.OK);
		}*/
		SemesterEntity semesterDetails=semesterRepository.findById(semId).get();
		System.out.println(semesterDetails);
		courseDetails.setSemester(semesterDetails);
		DepartmentEntity departmentDetails=departmentRepository.findById(deptId).get();
		System.out.println(departmentDetails);
		courseDetails.setDepartment(departmentDetails);
		courseRepository.save(courseDetails);
		return new ResponseEntity<String>("Course Details Added Successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	@Override
	public ResponseEntity<String> updateCourseDetails(String courseCode, CourseEntity courseDetails) throws CourseCodeNotFoundException {
		// TODO Auto-generated method stub
		return courseRepository.findById(courseCode)
				.map(course->{
					course.setCourseName(courseDetails.getCourseName());
					courseRepository.save(course);
					return new ResponseEntity<String>("Course Details Updated Successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElseThrow(()->new CourseCodeNotFoundException("Course code not found!"));
	}
	@Override
	public ResponseEntity<String> deleteCourseDetails(String courseCode) throws CourseCodeNotFoundException {
		// TODO Auto-generated method stub
		return courseRepository.findById(courseCode)
				.map(course->{
					courseRepository.delete(course);
					return new ResponseEntity<String>("Course Details Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElseThrow(()->new CourseCodeNotFoundException("Course code not found!"));
	}
	@Override
	public List<CourseEntity> getCourseDetailsBySemId(Long semId) throws SemesterNotFoundException {
		// TODO Auto-generated method stub
		if(!semesterRepository.existsById(semId))
		{
			throw new SemesterNotFoundException("Semester Not Found!,Enter the valid id");
		}
		List<CourseEntity> courseDetails=(List<CourseEntity>) courseRepository.getBySemId(semId);
		return courseDetails;
	}
	@Override
	public List<CourseEntity> getCourseDetailsByDeptId(Long deptId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		if(!departmentRepository.existsById(deptId))
		{
			throw new DepartmentNotFoundException("Department Not Found!,Enter the valid id");
		}
		List<CourseEntity> courseDetails=courseRepository.getByDeptId(deptId);
		return courseDetails;
	}

}
