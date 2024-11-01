package com.kh.hopeBook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.hopeBook.model.dao.HopeBookService;
import com.kh.hopeBook.model.vo.HopeBook;

/**
 * Servlet implementation class HopeBookEnrollFormController
 */
@WebServlet("/hopeBookInsert.ho")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String hopeUser = request.getParameter("hopeUser");
		String hopeTitle = request.getParameter("hopeTitle");
		String hopeAutor = request.getParameter("hopeAutor");
		String hopeContent = request.getParameter("hopeContent");
//		System.out.println(hopeUser);
//		System.out.println(hopeTitle);
//		System.out.println(hopeWriter);
//		System.out.println(hopeContent);
		
		HopeBook h = new HopeBook();
		h.setHopeUser(hopeUser);
		h.setHopeTitle(hopeTitle);
		h.setHopeAutor(hopeAutor);
		h.setHopeContent(hopeContent);
		System.out.println(h);
		
		int result = new HopeBookService().hopeBookInsert(h);
		
		
	}

}
