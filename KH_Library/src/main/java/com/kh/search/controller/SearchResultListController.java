package com.kh.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.search.model.service.SearchService;

/**
 * Servlet implementation class SearchResultListController
 */
@WebServlet("/list.se")
public class SearchResultListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String keyword = request.getParameter("search-keyword");
		String[] bookcList = (String[]) request.getParameterValues("search-book-category");
		String category = "";
		if(bookcList!=null) {
			category = String.join(",", bookcList);
		}else {
			ArrayList<BookCategoryInfo> cArr = new SearchService().selectBookCategoryList();
			category = Integer.toString(cArr.get(0).getCategoryNo());
			for(int i = 1; i<cArr.size(); i++) {
				category += ","+Integer.toString(cArr.get(i).getCategoryNo());
			}
		}
		
		ArrayList<Book> bookList = new SearchService().selectSearchList(category,keyword);
		//ArrayList<Board> boardList = new SearchService().searchBoard(category,keyword);
		
		request.setAttribute("search-result", bookList);
		request.getRequestDispatcher("/views/search/searchResultView.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
