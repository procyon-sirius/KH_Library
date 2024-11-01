package com.kh.hopeBook.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		int hno = Integer.parseInt(request.getParameter("hno"));
//		System.out.println(hno);
		
		HopeBook h = new HopeBookService().hopeBookDetail(hno);
//		System.out.println(h);
		
		if(h != null) {
			request.setAttribute("h", h);
			request.getRequestDispatcher("/views/hopeBook/hopeBookDetailView.jsp").forward(request, response);	
		}else {
			System.out.println(h+" 실패!");
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
