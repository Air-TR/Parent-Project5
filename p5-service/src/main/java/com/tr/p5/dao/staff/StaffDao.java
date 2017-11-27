package com.tr.p5.dao.staff;

import org.springframework.stereotype.Repository;

import com.tr.common.pagination.mybatis.PaginationList;
import com.tr.common.pagination.mybatis.dao.SuperDao;
import com.tr.p5.entity.Staff;

@Repository
public class StaffDao extends SuperDao {
	
	public PaginationList<Staff> selectPage(PaginationList<Staff> page, Staff record) {
		return super.selectPage("com.tr.p5.mapper.staff.StaffMapper.selectPage", record, page);
	}

}
