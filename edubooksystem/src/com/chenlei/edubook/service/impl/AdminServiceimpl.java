package com.chenlei.edubook.service.impl;

import com.chenlei.edubook.dao.AdminDao;
import com.chenlei.edubook.dao.impl.AdminDaoimpl;
import com.chenlei.edubook.domain.Assorter;
import com.chenlei.edubook.service.AdminService;

public class AdminServiceimpl implements AdminService{
	private AdminDao adminDao = new AdminDaoimpl();
	
	@Override
	public Assorter LoginCheck(Assorter assorter) {
		// TODO Auto-generated method stub
		return adminDao.AdminLoginCheck(assorter);
	}

}
