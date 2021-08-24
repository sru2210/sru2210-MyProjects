package com.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.DepartmentEntity;
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long>{
	
}
