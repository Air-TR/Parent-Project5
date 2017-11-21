package com.tr.p5.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tr.p5.entity.Staff;
import com.tr.p5.result.Result;
import com.tr.p5.service.staff.IStaffService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Staff")
@RestController
public class StaffController {
	
	@Autowired
	private IStaffService staffService;
	
	@ApiOperation(value = "根据id获取")
	@GetMapping("/staff/get/{id}")
	public Result<Staff> get(@PathVariable Integer id) {
		return Result.success(staffService.get(id));
	}

}
