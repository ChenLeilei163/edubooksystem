package com.chenlei.edubook.dao;

import java.util.List;

import com.chenlei.edubook.domain.Bookinfo;

public interface BookinfoDao {
	
	public List<Bookinfo> getbooks(String sql);
	
	public List<Bookinfo> getBookinfos(int page);
	
	public int saveBook(Bookinfo bookinfo);
	
	public int deleteBook(String bookid);
	
	public int getTotalRecord();
	
	
	
}
