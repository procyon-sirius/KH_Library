package com.kh.hopeBook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kh.hopeBook.model.service.HopeBookService;
import com.kh.hopeBook.model.vo.HopeBook;

/**
 * Servlet implementation class HopeBookDetailView
 */
@WebServlet("/detail.ho")
public class HopeBookDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HopeBookDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hopeNum = Integer.parseInt(request.getParameter("hopeNum"));
//		System.out.println(hopeNum);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		System.out.println(currentPage);
		String oder = request.getParameter("sort");
//		System.out.println(oder);
		
		HopeBook h = new HopeBookService().hopeBookDetail(hopeNum);
//		System.out.println(h);
//		HopeBook h = null;
		
		HttpSession session = request.getSession();
		
		if(h != null) {
			request.setAttribute("h", h);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("oder", oder);
			request.getRequestDispatcher("/views/hopeBook/hopeBookDetailView.jsp").forward(request, response);	
		}else {
			session.setAttribute("alertMsg", "접근 실패");
			response.sendRedirect(request.getContextPath()+"/select.ho?sort=aOrder&currentPage="+currentPage);
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
