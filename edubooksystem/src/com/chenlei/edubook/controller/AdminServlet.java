package com.chenlei.edubook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenlei.edubook.dao.AdminDao;
import com.chenlei.edubook.dao.impl.AdminDaoimpl;
import com.chenlei.edubook.domain.Assorter;
import com.chenlei.edubook.service.AdminService;
import com.chenlei.edubook.service.impl.AdminServiceimpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao = new AdminDaoimpl();
	private AdminService adminService = new AdminServiceimpl();
	private Assorter assorter = null;
    
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String adminname = request.getParameter("adminname");
		String adminpwd = request.getParameter("adminpwd");
		
		assorter = new Assorter();
		assorter.setArname(adminname);
		assorter.setArpwd(adminpwd);
//		System.out.println(111);
		if(adminService.LoginCheck(assorter) != null){
			request.getSession().setAttribute("assorter", adminService.LoginCheck(assorter));
			response.sendRedirect("adminMng/adminIndex.jsp");
		}else{
			request.setAttribute("feedback", "您的用户名或密码输入不匹配，请核对后再登。");
			response.sendRedirect("adminMng/adminLogin.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
//		System.out.println(method);
		
		switch (method) {
		case "login":
			login(request, response);
			break;

		default:
			break;
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
