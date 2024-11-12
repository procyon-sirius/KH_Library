package com.kh.board.controller.freeBoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.FreeboardService;

/**
 * Servlet implementation class FreeBoardDeleteController
 */
@WebServlet("/delete.fb")
public class FreeBoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		int boardNo = Integer.parseInt(request.getParameter("nno"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		int result = new FreeboardService().deleteFreeBoard(boardNo);
		HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "게시판 글이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/freeBoard?currentPage="+currentPage);
		}else {
			session.setAttribute("alertMsg", "게시판 글삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/");
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
