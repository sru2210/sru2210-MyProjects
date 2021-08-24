package com.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.CourseEntity;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,String>{
	@Query("SELECT c FROM CourseEntity c WHERE c.semester.id=:semesterId")
	List<CourseEntity> getBySemId(@Param("semesterId") Long semId);
	@Query("FROM CourseEntity c WHERE c.department.deptId=:deptId")
	List<CourseEntity> getByDeptId(@Param("deptId") Long deptId);
}
