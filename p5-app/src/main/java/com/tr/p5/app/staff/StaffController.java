package com.tr.p5.app.staff;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tr.common.pagination.mybatis.PaginationList;
import com.tr.common.result.Result;
import com.tr.p5.dao.staff.StaffDao;
import com.tr.p5.entity.Staff;
//import com.tr.p5.interceptor.Interceptor1;
import com.tr.p5.jpa.staff.StaffRepository;
import com.tr.p5.mapper.staff.StaffMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Staff")
@RestController
public class StaffController {
	
//	@Autowired
//	private IStaffService staffService;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private StaffDao staffDao;
	
	@ApiOperation(value = "职员分页列表")
	@PostMapping("/staff/list")
	public Result<PaginationList<Staff>> pageList(@RequestBody PaginationList<Staff> page, HttpServletRequest request) {
		Staff staff = null;
		if (page.getDatas() != null) {
			staff = page.getDatas().get(0);
		}
        page = staffDao.selectPage(page, staff);
        return Result.success(page);
	}
	
//	@ApiOperation(value = "职员登录")
//	@PostMapping("/staff/login")
//	public Result<Staff> login(@RequestParam String phone, @RequestParam String password, HttpSession session) {
//		Staff user = staffService.login(phone, password);
//		if (user != null) {
//			session.setAttribute(Interceptor1.SESSION_ATTR_USER, user);
//			return Result.success(user);
//		}
//		return Result.fail(ResultEnum.LOGIN_FAIL);
//	}
	
	@ApiOperation(value = "根据id获取")
	@GetMapping("/staff/get/{id}")
	public Result<Staff> get(@PathVariable Integer id) {
		return Result.success(staffMapper.selectById(id));
	}
	
	@ApiOperation(value = "根据全部职员列表")
	@GetMapping("/staff/list-all")
	public Result<List<Staff>> list() {
		return Result.success(staffRepository.findAll());
	}

}
