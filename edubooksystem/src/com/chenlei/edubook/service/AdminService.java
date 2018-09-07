package com.chenlei.edubook.service;

import com.chenlei.edubook.domain.Assorter;
import com.chenlei.edubook.domain.Bookinfo;

public interface AdminService {
	
	public Assorter LoginCheck(Assorter assorter);

	public int getTotalIndex();
	
}
