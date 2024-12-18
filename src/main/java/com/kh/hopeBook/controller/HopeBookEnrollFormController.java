package com.kh.hopeBook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.hopeBook.model.service.HopeBookService;
import com.kh.hopeBook.model.vo.HopeBook;

/**
 * Servlet implementation class HopeBookEnrollFormController
 */
@WebServlet("/insert.ho")
public class HopeBookEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HopeBookEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/hopeBook/hopeBookEnrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int hopeUser = Integer.parseInt(request.getParameter("hopeUser"));
		String hopeTitle = request.getParameter("hopeTitle");
		String hopeAutor = request.getParameter("hopeAutor");
		String hopeContent = request.getParameter("hopeContent");
		String hopePublic = request.getParameter("hopePublic");
//		System.out.println(hopeUser);
//		System.out.println(hopeTitle);
//		System.out.println(hopeAutor);
//		System.out.println(hopeContent);
//		System.out.println(hopePublic);
		
		HopeBook h = new HopeBook();
		h.setHopeUser(hopeUser);
		h.setHopeTitle(hopeTitle);
		h.setHopeAutor(hopeAutor);
		h.setHopeContent(hopeContent);
		h.setHopePublic(hopePublic);
//		System.out.println(h);
		
		int result = new HopeBookService().hopeBookInsert(h);
//		int result = 0;
		
		HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "신청 성공");
			response.sendRedirect(request.getContextPath()+"/select.ho?currentPage=1");
		}else {
			session.setAttribute("alertMsg", "신청 실패");
			response.sendRedirect(request.getContextPath()+"/insert.ho");
		}
	}

}
