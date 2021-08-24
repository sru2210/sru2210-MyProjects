package com.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enrollment.entity.DepartmentEntity;
import com.enrollment.exception.DepartmentNotFoundException;
import com.enrollment.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public ResponseEntity<String> addDepartmentDetails(DepartmentEntity departmentDetails) {
		// TODO Auto-generated method stub
		departmentRepository.save(departmentDetails);
		return new ResponseEntity<String>("Department details added successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	@Override
	public List<DepartmentEntity> getDepartmentDetails() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}
	@Override
	public ResponseEntity<DepartmentEntity> getParticularDepartmentDetails(Long deptId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		if(!departmentRepository.existsById(deptId))
		{
			throw new DepartmentNotFoundException("Department Not Found,Enter the valid ID!");
		}
		DepartmentEntity deptEntity=departmentRepository.findById(deptId).get();
		return new ResponseEntity<DepartmentEntity>(deptEntity,new HttpHeaders(),HttpStatus.OK);
	}
	@Override
	public ResponseEntity<String> deleteDepartmentDetails(long deptId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
			return departmentRepository.findById(deptId)
					.map(department->{
						departmentRepository.delete(department);
						return new ResponseEntity<String>("Department Details Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
					}).orElseThrow(()->new DepartmentNotFoundException("Department Not Found,Enter the valid ID!"));
	}
	@Override
	public ResponseEntity<String> updateDepartmentDetails(Long deptId, DepartmentEntity departmentDetails) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		return departmentRepository.findById(deptId)
				.map(department->{
					department.setDeptName(departmentDetails.getDeptName());
					departmentRepository.save(department);
					return new ResponseEntity<String>("Department Details Updated Successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElseThrow(()->new DepartmentNotFoundException("Department Not Found,Enter the valid ID!"));
	}

}
