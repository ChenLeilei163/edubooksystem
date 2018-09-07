package com.chenlei.edubook.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chenlei.edubook.dao.BookinfoDao;
import com.chenlei.edubook.dao.impl.BookinfoDaoimpl;
import com.chenlei.edubook.domain.Bookinfo;
import com.chenlei.edubook.service.BookinfoService;
import com.chenlei.edubook.service.impl.BookinfoServiceimpl;
import com.chenlei.edubook.util.FileNameUtil;

/**
 * Servlet implementation class ProductMsgServlet
 */
@WebServlet("/ProductMsgServlet")
public class ProductMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Bookinfo bookinfo = null;
	private List<Bookinfo> bookinfos = null;
	private String[] books = new String[5] ;
	private String newFileName = "";
 	private BookinfoService bookinfoService = new BookinfoServiceimpl();
 	private BookinfoDao bookinfoDao = new BookinfoDaoimpl();
    
	public void msgslt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookname = request.getParameter("bookname");
		String bookauthor = request.getParameter("bookauthor");
		String bookprice = request.getParameter("bookprice");
		String chubanshe = request.getParameter("chubanshe");
		String shihexueke = request.getParameter("shihexueke");
		String isbn = request.getParameter("isbn");
		String shihenianji = request.getParameter("shihenianji");
		String btype = request.getParameter("btype");
		System.out.println("dsafgh");
		String sql = "select * Form bookinfo where 1 == 1";
		
		if(bookname!=null){
			sql = sql + " and bookname=" + bookname;
		}
		
		if(bookauthor!=null){
			sql = sql + " and bookauthor=" + bookauthor;
		}
		
		if(bookprice!=null){
			sql = sql + " and bookprice=" + bookprice;
		}
		
		if(chubanshe!=null){
			sql = sql + " and chubanshe=" + chubanshe;
		}
		
		if(shihexueke!=null){
			sql = sql + " and shihexueke=" + shihexueke;
		}
		
		if(isbn!=null){
			sql = sql + " and isbn=" + isbn;
		}
		
		if(shihenianji!=null){
			sql = sql + " and shihenianji=" + shihenianji;
		}
		
		if(btype!=null){
			sql = sql + " and btype like %" + btype + "%";
		}
		
		sql += " limit ?,10";
		System.out.println("aaa:" +sql);
		BookinfoDao bookinfoDao = new BookinfoDaoimpl();
		List<Bookinfo> bookinfos = new ArrayList<Bookinfo>();
		
		bookinfos = bookinfoDao.getbooks(sql);
		System.out.println("222");
		request.setAttribute("bookinfos", bookinfos);
		request.getRequestDispatcher("adminMng/product_select1.jsp").forward(request,response);
		
	}

	 //上传
    public void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String serverPath = request.getServletContext().getRealPath("/");
    	int sizeThreshold = 4096;
    	File repository = new File(serverPath);
    	DiskFileItemFactory dff = new DiskFileItemFactory(sizeThreshold, repository);
    	
    	ServletFileUpload fileUpload =  new ServletFileUpload(dff);
    	
    	try {
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			for (int i = 0; i < fileItems.size(); i++) {
				FileItem item = fileItems.get(i);
				if (item.isFormField()) {
					books[i] = item.getString();
				}else {
					books[i] = item.getName();
					newFileName = "upload/" + FileNameUtil.getNewFileName(books[i]);
					File file = new File(serverPath + newFileName);
					
					item.write(file);
				}
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
	
	public void saveBook(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		float bookprice = Float.parseFloat(request.getParameter("bookprice"));
		String bookname = request.getParameter("bookname");
		String bookimg = request.getParameter("bookimg");
		String btype = request.getParameter("btype");
		String shihezhuanye = request.getParameter("shihezhuanye");
		String shihenianji = request.getParameter("shihenianji");
		String author = request.getParameter("author");
		String chubanshe = request.getParameter("chubanshe");
		String shijian = request.getParameter("shijian");
		String isbn = request.getParameter("isbn");
		int jifen = Integer.parseInt(request.getParameter("jifen"));
		int free_shipping_num = Integer.parseInt(request.getParameter("free_shipping_num"));
		float freight = Float.parseFloat(request.getParameter("freight"));
		
		bookinfo = new Bookinfo();
		bookinfo.setBookprice(bookprice);
		bookinfo.setBookname(bookname);
		bookinfo.setBookimg(bookimg);
		bookinfo.setBtype(btype);
		bookinfo.setShihezhuanye(shihezhuanye);
		bookinfo.setShihenianji(shihenianji);
		bookinfo.setAuth(author);
		bookinfo.setChubanshe(chubanshe);
		bookinfo.setShijian(shijian);
		bookinfo.setIsbn(isbn);
		bookinfo.setJifen(jifen);
		bookinfo.setFree_shipping_num(free_shipping_num);
		bookinfo.setFreight(freight);

		if(bookinfoService.saveBook(bookinfo)){
			page(request, response);
		}else{
			response.sendRedirect("");
		}
		
	
	
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String bookid = request.getParameter("bookid");
		if(bookinfoService.deleteBook(bookid)){
			response.sendRedirect("product_select1.jsp");
		}
		
	}
	
	public void page(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//默认当前显示页码为第一页
				int pageIndex = 1;
				//如果page传的值为空，则说明最先进入的是第一页
//				System.out.println("if前"+pageIndex);
				if(request.getParameter("pageIndex") != null){
					pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
				}
//				System.out.println("if后"+pageIndex);
				request.setAttribute("userinfos", bookinfoDao.getBookinfos(pageIndex));
				
				request.setAttribute("pageIndex",pageIndex);
				
				request.setAttribute("totalPage", bookinfoService.getTotalPage());
				request.getRequestDispatcher("product_select1.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = "msgslt";
		if (request.getParameter("method") != null) {
			method = request.getParameter("method");
		}
		System.out.println(method);
		switch (method) {
		case "msgslt":
			msgslt(request,response);
			break;
		case "saveBook":
			saveBook(request,response);
			break;	
		case "page":
			page(request,response);
			break;
		case "delete":
			deleteBook(request,response);
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
