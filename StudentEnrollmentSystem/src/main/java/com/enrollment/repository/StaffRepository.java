package com.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long>{

}
