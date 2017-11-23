package com.tr.p5.controller.depot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.common.pagination.PaginationList;
import com.tr.common.result.Result;
import com.tr.p5.dao.depot.DepotDao;
import com.tr.p5.entity.Depot;
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

	@ApiOperation(value = "获取分页列表")
	@PostMapping("/depot/list")
	public Result<PaginationList<Depot>> pageList(@RequestBody PaginationList<Depot> page, HttpServletRequest request) {
		Depot depot = null;
		if (page.getDatas() != null) {
			depot = page.getDatas().get(0);
		}
        page = depotDao.selectPage(page, depot);
        return Result.success(page);
	}
	
	@ApiOperation(value = "根据id修改确认人")
	@PostMapping("/depot/updateConfirmPersonById")
	public Result<?> updateConfirmPersonById(@RequestParam Integer id, @RequestParam String confirmPerson) {
		depotRepository.updateConfirmPersonById(id, confirmPerson);
		return Result.success();
	}
	
	@ApiOperation(value = "根据id获取")
	@GetMapping("/depot/get/{id}")
	public Result<Depot> get(@PathVariable Integer id) {
		return Result.success(depotService.selectById(id));
	}
	
	@ApiOperation(value = "根据名称获取")
	@GetMapping("/depot/listByName")
	public Result<List<Depot>> listByName(@RequestParam String name) {
		return Result.success(depotService.selectListByName(name));
	}
	
	@ApiOperation(value = "根据名称获取")
	@GetMapping("/depot/listByPlace")
	public Result<List<Depot>> listByPlace(@RequestParam String place) {
		return Result.success(depotRepository.listByPlace(place));
	}
	
	@ApiOperation(value = "获取全部仓库列表")
	@PostMapping("/depot/list-all")
	public Result<List<Depot>> list(@RequestBody Depot depot) {
		return Result.success(depotMapper.selectList(depot));
	}
	
}
