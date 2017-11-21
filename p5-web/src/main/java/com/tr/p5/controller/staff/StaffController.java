package com.tr.p5.controller.staff;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.p5.entity.Staff;
import com.tr.p5.interceptor.Interceptor1;
import com.tr.p5.jpa.staff.StaffRepository;
import com.tr.p5.result.Result;
import com.tr.p5.result.ResultEnum;
import com.tr.p5.service.staff.IStaffService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Staff")
@RestController
public class StaffController {
	
	@Autowired
	private IStaffService staffService;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@ApiOperation(value = "职员登录")
	@PostMapping("/staff/login")
	public Result<Staff> login(@RequestParam String phone, @RequestParam String password, HttpSession session) {
		Staff user = staffService.login(phone, password);
		if (user != null) {
			session.setAttribute(Interceptor1.SESSION_ATTR_USER, user);
			return Result.success(user);
		}
		return Result.fail(ResultEnum.LOGIN_FAIL);
	}
	
	@ApiOperation(value = "根据id获取")
	@GetMapping("/staff/get/{id}")
	public Result<Staff> get(@PathVariable Integer id) {
		return Result.success(staffService.get(id));
	}
	
	@ApiOperation(value = "根据全部职员列表")
	@GetMapping("/staff/list")
	public Result<List<Staff>> list() {
		return Result.success(staffRepository.findAll());
	}

}
