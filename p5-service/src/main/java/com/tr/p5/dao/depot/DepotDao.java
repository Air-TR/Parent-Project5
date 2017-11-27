package com.tr.p5.dao.depot;

import org.springframework.stereotype.Repository;

import com.tr.common.pagination.mybatis.PaginationList;
import com.tr.common.pagination.mybatis.PaginationOrdersList;
import com.tr.common.pagination.mybatis.dao.SuperDao;
import com.tr.p5.entity.Depot;

@Repository
public class DepotDao extends SuperDao {
	
	public PaginationList<Depot> selectPage(PaginationList<Depot> page, Depot record) {
		return super.selectPage("com.tr.p5.mapper.depot.DepotMapper.selectPage", record, page);
	}
	
	public PaginationOrdersList<Depot> selectPage(PaginationOrdersList<Depot> page, Depot record) {
		return super.selectPage("com.tr.p5.mapper.depot.DepotMapper.selectPage", record, page);
	}

}
