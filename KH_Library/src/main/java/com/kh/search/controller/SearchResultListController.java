package com.kh.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.book.model.service.BookService;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.PageInfo;
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

		String keywordCategory = request.getParameter("search-keyword-category");
		String keyword = request.getParameter("search-keyword");
		
		String[] keyCategory = null;
		if(keywordCategory.equals("all")) {//검색 키워드 카테고리
			keyCategory = new String[]{keyword,keyword,keyword};
		}else if(keywordCategory.equals("title")) {
			keyCategory = new String[]{keyword,"@#","@#"};
		}else if(keywordCategory.equals("author")) {
			keyCategory = new String[]{"@#",keyword,"@#"};
		}else if(keywordCategory.equals("publisher")) {
			keyCategory = new String[]{"@#","@#",keyword};
		}
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
		
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new SearchService().listCount(keyCategory,category);
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage-1) / pageLimit * pageLimit +1;
		
		endPage = startPage + pageLimit -1;
		
		if(maxPage<endPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		
		
		
		ArrayList<Book> bookList = new SearchService().selectSearchList(keyCategory,category,pi);
		//ArrayList<Board> boardList = new SearchService().searchBoard(category,keyword);
		request.setAttribute("pi", pi);					
		request.setAttribute("searchResult", bookList);
		request.setAttribute("keyword", keyword);
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
