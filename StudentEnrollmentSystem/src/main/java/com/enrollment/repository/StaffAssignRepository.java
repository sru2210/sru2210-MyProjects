package com.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.StaffAssignEntity;

@Repository
public interface StaffAssignRepository extends JpaRepository<StaffAssignEntity,Long>{

	@Query("select s from StaffAssignEntity s where s.dept.deptId=:deptId")
	List<StaffAssignEntity> findByDeptId(@Param("deptId")Long deptId);
	
	//List<StaffAssignEntity> findByDeptId(Long deptId);
	

	
}
