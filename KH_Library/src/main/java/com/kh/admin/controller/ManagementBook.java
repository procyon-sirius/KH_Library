package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.AdminBookService;
import com.kh.book.model.vo.Book;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class ManagementBook
 */
@WebServlet("/management.bk")
public class ManagementBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		if(m==null || !m.getUserId().equals("admin")) {
			request.setAttribute("errorMsg", "관리자 계정만 접근할 수 있습니다.");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		}else {
			ArrayList<Book> list = new AdminBookService().selectAllBook();
			request.setAttribute("mode", "book");
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/member/admin/admin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
