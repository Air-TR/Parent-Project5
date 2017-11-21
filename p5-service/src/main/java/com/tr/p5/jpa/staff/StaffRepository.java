package com.tr.p5.jpa.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tr.p5.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	
}