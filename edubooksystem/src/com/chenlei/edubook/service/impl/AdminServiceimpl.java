package com.chenlei.edubook.service.impl;

import com.chenlei.edubook.domain.Adminer;
import com.chenlei.edubook.service.AdminService;

public class AdminServiceimpl implements AdminService{
//	private AdminDao admin = new AdminDaoimpl();
	
	@Override
	public boolean AdminLoginCheck(Adminer adminer) {
		
//		return admin.AdminLoginCheck(adminer);
		return false;
	}

}
