package com.kh.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.book.model.service.BookService;

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
		System.out.println(bookId);
		System.out.println(userNo);
		int result = new BookService().insertRentBook(bookId,userNo);
		System.out.println(result);
		String alertMsg = "";
		if(result == -1) {
			alertMsg = "최대 대출 권수를 넘겼습니다. 인당 대출 가능 권수는 5권입니다.";
		}else if(result == 0) {
			alertMsg = "대출 실패. 관리자에게 문의하세요.";
		}else if(result > 0){
			alertMsg = "대출 완료";
		}
		System.out.println(alertMsg);
		HttpSession session = request.getSession();
		session.setAttribute("alertMsg", alertMsg);
		response.sendRedirect(request.getContextPath());
	}

}
