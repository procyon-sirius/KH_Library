package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.admin.model.service.AdminService;
import com.kh.book.model.service.BookService;
import com.kh.book.model.vo.Book;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ChangeStatusBook
 */
@WebServlet("/changeStatusBook.ma")
public class ChangeStatusBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatusBook() {
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
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		if(m==null || !m.getUserId().equals("admin")) {
			request.setAttribute("errorMsg", "관리자 계정만 접근할 수 있습니다.");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		}else {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			String status = request.getParameter("status");
			
			Book book = null;
			
			int result = new AdminService().statusChangeBook(bookId,status);
			
			if(result>0) {
				book = new BookService().selectBook(bookId);
			}
			
			response.setContentType("json/application;charset=UTF-8");
			
			new Gson().toJson(book,response.getWriter());
		}
	}


}
