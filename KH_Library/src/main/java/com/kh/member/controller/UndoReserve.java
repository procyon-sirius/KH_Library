package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.controller.MemberSearchController;
import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class UndoReserve
 */
@WebServlet("/undoReserve.bk")
public class UndoReserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UndoReserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int result = new MemberService().undoReserve(bookId);
		String alertMsg = "";
		if(result>0) {
			alertMsg="예약 취소되었습니다.";
		}else {
			alertMsg="예약 취소 실패";
		}
		HttpSession session = request.getSession();
		session.setAttribute("alertMsg", alertMsg);

		String url = request.getHeader("referer");
		response.sendRedirect(url); //이전 경로 재요청
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
