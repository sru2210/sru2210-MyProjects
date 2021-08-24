package com.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.SemesterEntity;
@Repository
public interface SemesterRepository extends JpaRepository<SemesterEntity,Long>{

}
