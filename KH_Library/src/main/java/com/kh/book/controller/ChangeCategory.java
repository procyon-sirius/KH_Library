package com.kh.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.book.model.service.BookService;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.PageInfo;

/**
 * Servlet implementation class ChangeCategory
 */
@WebServlet("/changeCategory.bk")
public class ChangeCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int cno = Integer.parseInt(request.getParameter("categoryNo"));
		String age = request.getParameter("age");
		String order = request.getParameter("order");
		String ud = request.getParameter("ud");
		
		System.out.println(age);
		System.out.println(order);
		System.out.println(ud);
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		ArrayList<Book> list = new ArrayList<>();
		
		ArrayList<BookCategoryInfo> bci = new BookService().selectCategory();
		
		if(cno==0) {
			listCount = new BookService().listCount();
			
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			pageLimit = 10;
			boardLimit = 10;
			
			maxPage = (int)Math.ceil((double)listCount/boardLimit);
			
			if(currentPage != 1 && currentPage > maxPage) {
				request.setAttribute("errorMsg", "잘못된 접근입니다.");
				request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
			}
			
			startPage = (currentPage-1) / pageLimit * pageLimit +1;
			
			endPage = startPage + pageLimit -1;
			
			if(maxPage<endPage) {
				endPage=maxPage;
			}
			
			
			PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
			
			list = new BookService().allList(pi,age,order,ud);
			
			request.setAttribute("pi", pi);	
			request.setAttribute("list", list);	
			request.setAttribute("bci", bci);
			request.setAttribute("age", age);
			request.setAttribute("order", order);
			request.setAttribute("ud", ud);
			
		}else {
			listCount = new BookService().clistCount(cno);
			
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			pageLimit = 10;
			boardLimit = 10;
			
			maxPage = (int)Math.ceil((double)listCount/boardLimit);
			
			if(currentPage != 1 && currentPage > maxPage) {
				request.setAttribute("errorMsg", "잘못된 접근입니다.");
				request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
			}
			
			startPage = (currentPage-1) / pageLimit * pageLimit +1;
			
			endPage = startPage + pageLimit -1;
			
			if(maxPage<endPage) {
				endPage=maxPage;
			}
			
			
			PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
			
			
			list = new BookService().changeCategory(cno,pi,age,order,ud);
			request.setAttribute("pi", pi);	
			request.setAttribute("list", list);	
			request.setAttribute("bci", bci);
			request.setAttribute("age", age);
			request.setAttribute("order", order);
			request.setAttribute("ud", ud);
			
		}
		
		request.setAttribute("cno", cno);
		
//		response.sendRedirect(request.getContextPath()+"/changeCategory.bk?currentPage=1&categoryNo="+cno);
		
		request.getRequestDispatcher("/views/book/bookCategoryListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
