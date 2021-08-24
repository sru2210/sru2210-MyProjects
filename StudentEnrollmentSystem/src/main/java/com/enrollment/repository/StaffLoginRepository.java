package com.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.StaffEntity;
import com.enrollment.entity.StaffLoginEntity;

@Repository
public interface StaffLoginRepository extends JpaRepository<StaffLoginEntity, Long>{

}
