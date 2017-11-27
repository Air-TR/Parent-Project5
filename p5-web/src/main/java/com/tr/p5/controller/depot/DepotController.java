package com.tr.p5.controller.depot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.common.pagination.hibernate.PageReq;
import com.tr.common.pagination.hibernate.PageRes;
import com.tr.common.pagination.mybatis.PaginationList;
import com.tr.common.pagination.mybatis.PaginationOrdersList;
import com.tr.common.result.Result;
import com.tr.p5.dao.depot.DepotDao;
import com.tr.p5.entity.Depot;
import com.tr.p5.hibernate.DepotHibernate;
import com.tr.p5.jpa.depot.DepotRepository;
import com.tr.p5.mapper.depot.DepotMapper;
import com.tr.p5.service.depot.IDepotService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Depot")
@RestController
public class DepotController {
	
	@Autowired
	private DepotRepository depotRepository;
	
	@Autowired
	private DepotMapper depotMapper;
	
	@Autowired
	private DepotDao depotDao;
	
	@Autowired
	private IDepotService depotService;
	
	@Autowired
	private DepotHibernate depotHibernate;
	
	/**
	 * 研究目标：Hibernate及其分页
	 * 
	 * @param page
	 * @return
	 */
	@ApiOperation(value = "获取分页列表 Hibernate")
	@PostMapping("/depot/list-hibernate")
	public PageRes<List<Depot>> pageList(@RequestBody PageReq<Depot> page) {
		return depotHibernate.pageList(page);
	}
	
	/**
	 * 研究目标：Mybatis分页
	 * 
	 * @param page
	 * @return
	 */
	@ApiOperation(value = "获取分页列表 PaginationList")
	@PostMapping("/depot/list")
	public Result<PaginationList<Depot>> pageList(@RequestBody PaginationList<Depot> page) {
		Depot depot = null;
		if (page.getDatas() != null) {
			depot = page.getDatas().get(0);
		}
        page = depotDao.selectPage(page, depot);
        return Result.success(page);
	}
	
	/**
	 * 研究目标：Mybatis分页（带Orders）
	 * 
	 * @param page
	 * @return
	 */
	@ApiOperation(value = "获取分页列表 PaginationOrdersList")
	@PostMapping("/depot/list2")
	public Result<PaginationOrdersList<Depot>> pageList(@RequestBody PaginationOrdersList<Depot> page) {
		Depot depot = null;
		if (page.getDatas() != null) {
			depot = page.getDatas().get(0);
		}
		page = depotDao.selectPage(page, depot);
		return Result.success(page);
	}
	
	/**
	 * 研究目标：service的使用（调用Mapper）
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id获取")
	@GetMapping("/depot/get/{id}")
	public Result<Depot> get(@PathVariable Integer id) {
		return Result.success(depotService.selectById(id));
	}
	
	/**
	 * 研究目标：jpa的使用（按官方约定调用方法）
	 * 
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "根据名称获取")
	@GetMapping("/depot/listByName")
	public Result<List<Depot>> listByName(@RequestParam String name) {
		return Result.success(depotRepository.findByName(name));
	}
	
	/**
	 * 研究目标：jpa的使用（自定义方法，自定义HQL语句）
	 * 
	 * @param place
	 * @return
	 */
	@ApiOperation(value = "根据名称获取")
	@GetMapping("/depot/listByPlace")
	public Result<List<Depot>> listByPlace(@RequestParam String place) {
		return Result.success(depotRepository.listByPlace(place));
	}
	
	/**
	 * 研究目标：jpa的使用（自定义方法，自定义HQL语句，需添加事务注解）
	 * 
	 * @param id
	 * @param confirmPerson
	 * @return
	 */
	@ApiOperation(value = "根据id修改确认人")
	@PostMapping("/depot/updateConfirmPersonById")
	public Result<?> updateConfirmPersonById(@RequestParam Integer id, @RequestParam String confirmPerson) {
		depotRepository.updateConfirmPersonById(id, confirmPerson);
		return Result.success();
	}
	
	/**
	 * 研究目标：Mapper接口的使用（直接对应映射的xml文件）
	 * 
	 * @param depot
	 * @return
	 */
	@ApiOperation(value = "获取全部仓库列表")
	@PostMapping("/depot/list-all")
	public Result<List<Depot>> list(@RequestBody Depot depot) {
		return Result.success(depotMapper.selectList(depot));
	}
	
}
