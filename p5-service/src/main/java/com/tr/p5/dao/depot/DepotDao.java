package com.tr.p5.dao.depot;

import org.springframework.stereotype.Repository;

import com.tr.common.pagination.PaginationList;
import com.tr.common.pagination.dao.SuperDao;
import com.tr.p5.entity.Depot;

@Repository
public class DepotDao extends SuperDao {
	
	public PaginationList<Depot> selectPage(PaginationList<Depot> page, Depot record) {
		return super.selectPage("com.tr.p5.mapper.depot.DepotMapper.selectPage", record, page);
	}

}
