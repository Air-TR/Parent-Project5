package com.tr.p5.service.depot.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.p5.entity.Depot;
import com.tr.p5.jpa.depot.DepotRepository;
import com.tr.p5.mapper.depot.DepotMapper;
import com.tr.p5.service.depot.IDepotService;

@Service
public class DepotService implements IDepotService {
	
	@Autowired
	private DepotRepository depotRepository;
	
	@Autowired
	private DepotMapper depotMapper;

	@Override
	public int deleteById(Integer id) {
		return 0;
	}

	@Override
	public int insert(Depot record) {
		return 0;
	}

	@Override
	public Depot selectById(Integer id) {
		return depotMapper.selectById(id);
	}

	@Override
	public int updateById(Depot record) {
		return 0;
	}

	@Override
	public List<Depot> selectList(Depot record) {
		return depotMapper.selectList(record);
	}

	@Override
	public List<Depot> selectListByName(String name) {
		return depotRepository.findByName(name);
	}

}
