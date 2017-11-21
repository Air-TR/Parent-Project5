package com.tr.p5.service.depot;

import java.util.List;

import com.tr.p5.entity.Depot;

public interface IDepotService {
	
	int deleteById(Integer id);

    int insert(Depot record);

    Depot selectById(Integer id);

    int updateById(Depot record);
    
    List<Depot> selectList(Depot record);
    
    List<Depot> selectListByName(String name);

}
