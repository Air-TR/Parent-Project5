package com.tr.p5.mapper.staff;

import org.springframework.stereotype.Repository;

import com.tr.p5.entity.Staff;

@Repository
public interface StaffMapper {
	
    int deleteById(Integer id);

    int insert(Staff record);

    Staff selectById(Integer id);

    int updateById(Staff record);
    
}