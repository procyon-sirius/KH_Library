package com.kh.board.controller.freeBoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.FreeboardService;
import com.kh.board.model.service.ReplyService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class FBReplyInsertController
 */
@WebServlet("/insert.FBrp")
public class FreeBoardReplyEnrollForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardReplyEnrollForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board fb = new FreeboardService().selectFreeBoard(boardNo);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("freeBoard", fb);
		
		request.getRequestDispatcher("/views/board/freeBoard/freeBoardReplyEnrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		
		String content = request.getParameter("content");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int writerNo = Integer.parseInt(request.getParameter("writerNo"));
		
		int result = new ReplyService().insertFBReply(content,boardNo,writerNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "댓글 작성이 완료되었습니다");
			response.sendRedirect(request.getContextPath());
			
		}else {
			request.setAttribute("errorMsg", "댓글 작성에 실패하였습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	
	}

}
