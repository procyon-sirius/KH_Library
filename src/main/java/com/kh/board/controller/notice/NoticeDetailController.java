package com.kh.board.controller.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.NoticeService;
import com.kh.board.model.vo.Notice;

/**
 * Servlet implementation class NoticeListDetailController
 */
@WebServlet("/detail.no")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		
		// 조회수 증가    
		int numUp = new NoticeService().increaseCount(nno);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		if(numUp>0) {
			
			request.setAttribute("currentPage", currentPage);
			
			// 공지사항 상세조회
			Notice n = new NoticeService().selectNotice(nno);
			request.setAttribute("notice", n);
			
			// 이전글 다음글 조회
			ArrayList<Notice> preNnext = new NoticeService().preNnext(nno);
			request.setAttribute("preNnext", preNnext);
			request.getRequestDispatcher("views/board/notice/noticeDetailView.jsp").forward(request, response);
			
			
			
		}else {
			request.getSession().setAttribute("alertMsg", "공지글 조회 실패");
			response.sendRedirect(request.getContextPath()+"/list.no");
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
