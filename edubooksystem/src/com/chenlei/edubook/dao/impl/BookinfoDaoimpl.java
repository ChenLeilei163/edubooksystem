package com.chenlei.edubook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chenlei.edubook.dao.BookinfoDao;
import com.chenlei.edubook.domain.Assorter;
import com.chenlei.edubook.domain.Bookinfo;
import com.chenlei.edubook.util.DBUtil;

public class BookinfoDaoimpl extends DBUtil implements BookinfoDao{
	private Connection connection = null ;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Assorter assorter = null;
	private List<Bookinfo> bookinfos = null;
	private Bookinfo bookinfo = null;
	private String sql = "" ;
	
	@Override
	public List<Bookinfo> getbooks(String sql) {
		bookinfos = new ArrayList<Bookinfo>();
		connection = getCnt();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bookinfo = new Bookinfo();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getFloat("bookprice"));
				bookinfo.setDiscountprice(rs.getFloat("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getFloat("discount"));
				bookinfo.setState(rs.getInt("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setQixian(rs.getString("qixian"));
				bookinfo.setShihezhuanye(rs.getString("shihezhuanye"));
				bookinfo.setShihenianji(rs.getString("shihenianji"));
				bookinfo.setAuth(rs.getString("auth"));
				bookinfo.setChubanshe(rs.getString("chubanshe"));
				bookinfo.setShijian(rs.getString("shijian"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setJifen(rs.getInt("jifen"));
				
				Assorter assorter = new Assorter();
				assorter.setArname(rs.getString("arname"));
				
				bookinfo.setSendBookTime(rs.getString("sendBookTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setDuihuan(rs.getInt("duihuan"));
				bookinfo.setFree_shipping_num(rs.getInt("free_shipping_num"));
				bookinfo.setFreight(rs.getFloat("freight"));
				
				bookinfos.add(bookinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookinfos;
	}
	
	@Override
	public List<Bookinfo> getBookinfos(int page) {
		bookinfos = new ArrayList<Bookinfo>();
		connection = getCnt();
		sql = "select * from bookinfo limit ?,10";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, (page-1)*9);
			rs = ps.executeQuery();
			
			while(rs.next()){
				bookinfo = new Bookinfo();
				bookinfo.setBookid(rs.getString("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setBookprice(rs.getFloat("bookprice"));
				bookinfo.setDiscountprice(rs.getFloat("discountprice"));
				bookinfo.setBookimg(rs.getString("bookimg"));
				bookinfo.setBookdetails(rs.getString("bookdetails"));
				bookinfo.setDiscount(rs.getFloat("discount"));
				bookinfo.setState(rs.getInt("state"));
				bookinfo.setBtype(rs.getString("btype"));
				bookinfo.setQixian(rs.getString("qixian"));
				bookinfo.setShihezhuanye(rs.getString("shihezhuanye"));
				bookinfo.setShihenianji(rs.getString("shihenianji"));
				bookinfo.setAuth(rs.getString("auth"));
				bookinfo.setChubanshe(rs.getString("chubanshe"));
				bookinfo.setShijian(rs.getString("shijian"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setJifen(rs.getInt("jifen"));
				
				Assorter assorter = new Assorter();
				assorter.setArname(rs.getString("arname"));
				
				bookinfo.setSendBookTime(rs.getString("sendBookTime"));
				bookinfo.setHomeImage(rs.getString("homeImage"));
				bookinfo.setDuihuan(rs.getInt("duihuan"));
				bookinfo.setFree_shipping_num(rs.getInt("free_shipping_num"));
				bookinfo.setFreight(rs.getFloat("freight"));
				
				bookinfos.add(bookinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return bookinfos;
	}
	
	@Override
	public int saveBook(Bookinfo bookinfo) {
		connection = getCnt();
		sql = "insert into bookinfo values(?,?,)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, bookinfo.getBookid());
			ps.setString(2, bookinfo.getBookname());
			ps.setFloat(3, bookinfo.getBookprice());
			ps.setFloat(4, bookinfo.getDiscountprice());
			ps.setString(5, bookinfo.getBookimg());
			ps.setString(6, bookinfo.getBookdetails());
			ps.setFloat(7, bookinfo.getDiscount());
			ps.setInt(8, bookinfo.getState());
			ps.setString(9, bookinfo.getBtype());
			ps.setString(10, bookinfo.getQixian());
			ps.setString(11, bookinfo.getShihezhuanye());
			ps.setString(12, bookinfo.getShihenianji());
			ps.setString(13, bookinfo.getAuth());
			ps.setString(14, bookinfo.getChubanshe());
			ps.setString(15, bookinfo.getShijian());
			ps.setString(16, bookinfo.getIsbn());
			ps.setInt(17, bookinfo.getGrade());
			ps.setInt(18, bookinfo.getJifen());
			ps.setString(19, bookinfo.getSendBookTime());
			ps.setString(20, bookinfo.getHomeImage());
			ps.setInt(21, bookinfo.getDuihuan());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBook(String bookid) {
		sql = "delete from bookinfo where bookid = ?";
		connection = getCnt();
		 
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, bookid);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return 0;
	}

	@Override
	public int getTotalRecord() {
		connection = getCnt();
		sql = "select count(*) c from bookinfo";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return 0;
	}



}
