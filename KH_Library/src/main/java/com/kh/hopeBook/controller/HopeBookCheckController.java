package com.kh.hopeBook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.hopeBook.model.service.HopeBookService;

/**
 * Servlet implementation class HopeBookCheckController
 */
@WebServlet("/checkHope.ho")
public class HopeBookCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HopeBookCheckController() {
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
		
		int hopeNum = Integer.parseInt(request.getParameter("hopeNum"));
//		System.out.println(hopeNum);
			
		int result = new HopeBookService().hopeCheck(hopeNum);
		
		HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "확인 완료");
			response.sendRedirect(request.getContextPath()+"/select.ho?currentPage=1");
		}else {
			session.setAttribute("alertMsg", "확인 실패");
			response.sendRedirect(request.getContextPath()+"/detail.ho?hopeNum="+hopeNum);
		}
	}

}
