package com.chenlei.edubook.service;

import java.util.List;

import com.chenlei.edubook.domain.Bookinfo;

public interface BookinfoService {

	public List<Bookinfo> getbooks(String sql);
	
	public List<Bookinfo> getBookinfos(int page);
	
	public boolean saveBook(Bookinfo bookinfo);
	
	public boolean deleteBook(String bookid);
	
	public int getTotalPage();
}
