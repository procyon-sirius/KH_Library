package com.kh.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.book.model.service.BookService;
import com.kh.member.model.dao.MemberDao;

/**
 * Servlet implementation class BookRentController
 */
@WebServlet("/rent.bk")
public class BookRentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRentController() {
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
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new BookService().insertRentBook(bookId,userNo);
		
		
		String alertMsg = "";
		if(result == -1) {
			alertMsg = "대출 실패. 현재 대출중인 책과 예약중인 책의 개수 합이 대출 상한을 넘을 수 없습니다.";
		}else if(result == 0) {
			alertMsg = "대출 실패. 관리자에게 문의하세요.";
		}else if(result > 0){
			alertMsg = "대출 완료";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("alertMsg", alertMsg);

		String url = request.getHeader("referer");
		response.sendRedirect(url); //이전 경로 재요청
	}

}
