package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MyBookReturnController
 */
@WebServlet("/reBook.me")
public class MyBookReturnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBookReturnController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		int result = new MemberService().bookReturn(bookId);
		
		HttpSession session = request.getSession();
		
		if(result>0) {
			
			session.setAttribute("alertMsg", "반납되었습니다. 책은 도서관 앞 반납수거함에 넣어 주세요");
			
			response.sendRedirect(request.getContextPath()+"/mybook.me");
												
		}else {
			
			session.setAttribute("errorMsg","책 반납 실패");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
			
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
