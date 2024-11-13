package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.AdminMemberService;
import com.kh.book.model.vo.Rent;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class RentLimitController
 */
@WebServlet("/rentL.me")
public class RentLimitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentLimitController() {
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
			String temp = request.getParameter("uNo");
			int userNo = Integer.parseInt(temp);
			int count;
			
			count = new AdminMemberService().rentCount(userNo);
			Member mem = new AdminMemberService().memberInfo(userNo);
			request.setAttribute("mem", mem);
			request.setAttribute("count", count);
			request.setAttribute("mode", "rentLimit");
			request.getRequestDispatcher("/views/member/admin/admin.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rentLimit = Integer.parseInt(request.getParameter("rentLimit"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new AdminMemberService().updateLimit(rentLimit,userNo);
		
		String alertMsg = "";
		
		if(result>0) {
			alertMsg ="변경 완료";
		}else {
			alertMsg ="변경 실패";
		}
		
		request.setAttribute("alertMsg", alertMsg);
		request.setAttribute("mode", "member");
		request.getRequestDispatcher("/views/member/admin/admin.jsp").forward(request, response);
		
	}

}
