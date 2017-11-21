package com.tr.p5.mapper.depot;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tr.p5.entity.Depot;

@Repository
public interface DepotMapper {
	
    int deleteById(Integer id);

    int insert(Depot record);

    Depot selectById(Integer id);

    int updateById(Depot record);
    
    List<Depot> selectList(Depot record);
    
}