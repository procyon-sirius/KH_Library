package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/mypage.me")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")==null) {
			
			session.setAttribute("alertMsg", "로그인 후 이용가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
		}else {
			
			request.getRequestDispatcher("/views/member/myPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member m = new Member(userId,userName,phone,email,address);
		
		int result = new MemberService().updateMember(m);
		
		HttpSession session = request.getSession();
		
		if(result>0) {
			
			session.setAttribute("alertMsg", "정보수정 되었습니다.");
			
			String userPwd =((Member)session.getAttribute("loginUser")).getUserPwd();
			Member updateMem = new MemberService().loginMember(userId,userPwd);
			
			session.setAttribute("loginUser", updateMem);
			
			response.sendRedirect(request.getContextPath()+"/mypage.me");
			
		}else {
			
			session.setAttribute("alertMsg", "정보수정을 실패했습니다.");
				
			response.sendRedirect(request.getContextPath()+"/mypage.me");
			
		}
		
		
		
		
		
		
	}

}
