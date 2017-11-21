package com.tr.p5.service.staff.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.p5.entity.Staff;
import com.tr.p5.exception.MyException;
import com.tr.p5.jpa.staff.StaffRepository;
import com.tr.p5.result.ResultEnum;
import com.tr.p5.service.staff.IStaffService;

@Service
public class StaffService implements IStaffService {
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public Staff get(Integer id) {
		return staffRepository.findOne(id);
	}

	@Override
	public Staff login(String phone, String password, HttpSession session) {
		Staff record = staffRepository.findByPhone(phone);
		if (record != null && record.getPassword().equals(password)) {
			session.setAttribute("user", record);
			return record;
		}
		throw new MyException(ResultEnum.LOGIN_FAIL);
	}

}
