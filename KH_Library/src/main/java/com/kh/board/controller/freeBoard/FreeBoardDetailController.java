package com.kh.board.controller.freeBoard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.FreeboardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class FreeBoardDetailController
 */
@WebServlet("/detail.fb")
public class FreeBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardDetailController() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int nno = Integer.parseInt(request.getParameter("nno"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int numUp = new FreeboardService().increaseCount(nno);
		
		if(numUp>0) {
			
			request.setAttribute("currentPage", currentPage);
			
			Board freeBoard = new FreeboardService().selectFreeBoard(nno);
			request.setAttribute("freeBoard", freeBoard);
			
			ArrayList<Board> preNnext = new FreeboardService().preNnext(nno);
			request.setAttribute("preNnext", preNnext);
			request.getRequestDispatcher("views/board/freeBoard/freeBoardDetailView.jsp").forward(request, response);;
			
		}else {
			request.getSession().setAttribute("alertMsg", "공지글 조회 실패");
			response.sendRedirect(request.getContextPath()+"/freeBoard");
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
