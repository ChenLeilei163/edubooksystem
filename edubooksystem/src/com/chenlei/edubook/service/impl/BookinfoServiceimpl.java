package com.chenlei.edubook.service.impl;

import java.util.List;

import com.chenlei.edubook.dao.BookinfoDao;
import com.chenlei.edubook.dao.impl.BookinfoDaoimpl;
import com.chenlei.edubook.domain.Bookinfo;
import com.chenlei.edubook.service.BookinfoService;

public class BookinfoServiceimpl implements BookinfoService{
	private BookinfoDao bookinfoDao = new BookinfoDaoimpl();
	

	@Override
	public List<Bookinfo> getbooks(String sql) {
		// TODO Auto-generated method stub
		return bookinfoDao.getbooks(sql);
	}

	@Override
	public List<Bookinfo> getBookinfos(int page) {
		// TODO Auto-generated method stub
		return bookinfoDao.getBookinfos(page);
	}

	@Override
	public boolean saveBook(Bookinfo bookinfo) {
		
		return bookinfoDao.saveBook(bookinfo) > 0;
	}

	@Override
	public boolean deleteBook(String bookid) {
		
		return bookinfoDao.deleteBook(bookid) >0;
	}

	@Override
	public int getTotalPage() {
		int totalPage = bookinfoDao.getTotalRecord();
		if(totalPage % 10 == 0){
			return totalPage/10;
		}else{
			return totalPage/10 + 1;
		}
	}



}
