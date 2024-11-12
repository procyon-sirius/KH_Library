package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminBookService;
import com.kh.book.model.vo.BookCategoryInfo;

/**
 * Servlet implementation class InsertBookCategory
 */
@WebServlet("/insertBookCategory.ma")
public class InsertBookCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String temp = request.getParameter("insertCategoryNo");
		int cno = Integer.parseInt(temp);
		String cname = request.getParameter("insertCategoryName");
		
		BookCategoryInfo cInfo = new BookCategoryInfo(cno,cname);
		
		int result = 0;
		
		result = new AdminBookService().insertNewBookCategoryInfo(cInfo);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
