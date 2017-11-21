package com.tr.p5.service.staff;

import javax.servlet.http.HttpSession;

import com.tr.p5.entity.Staff;

public interface IStaffService {
	
	Staff get(Integer id);

	Staff login(String username, String password, HttpSession session);

}
