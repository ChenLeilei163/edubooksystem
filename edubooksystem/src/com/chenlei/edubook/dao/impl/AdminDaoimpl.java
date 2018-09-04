package com.chenlei.edubook.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chenlei.edubook.dao.AdminDao;
import com.chenlei.edubook.domain.Assorter;
import com.chenlei.edubook.util.DBUtil;

public class AdminDaoimpl extends DBUtil implements AdminDao{
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = "";
	private Assorter assorter = null;

	@Override
	public Assorter AdminLoginCheck(Assorter assorter) {
		connection = getCnt();
		sql = "select * from assorter_right where arname = ? and arpassword = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, assorter.getArname());
			ps.setString(2, assorter.getArpwd());
			rs = ps.executeQuery();
			while (rs.next()) {
				assorter = new Assorter();
				assorter.setArname(rs.getString("arname"));
				assorter.setArpwd(rs.getString("arpassword"));
				assorter.setBumen(rs.getString("bumen"));
				assorter.setBumename(rs.getString("bumename"));
				assorter.setUnitname(rs.getString("unitname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return assorter;
	}
}
