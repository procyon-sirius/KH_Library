package com.kh.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
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
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String pwdUpdate = request.getParameter("pwdUpdate");
		
		System.out.println(userId);
		
		HashMap<String,String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		map.put("pwdUpdate", pwdUpdate);
		
		int result = new MemberService().updatePwd(map);
		
		HttpSession session = request.getSession();
		
		if(result>0) {
			
			session.setAttribute("alertMsg", "비밀번호 변경되었으니 다시 로그인해주세요." );
			
			session.removeAttribute("loginUser");
			
			response.sendRedirect(request.getContextPath());
								
		}else {
			
			session.setAttribute("errorMsg","비밀번호 변경 실패");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
						
		}
																				
		
	}

}
