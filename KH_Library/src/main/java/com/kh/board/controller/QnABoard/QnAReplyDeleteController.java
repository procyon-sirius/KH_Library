package com.kh.board.controller.QnABoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.ReplyService;

/**
 * Servlet implementation class QnAReplyDeleteController
 */
@WebServlet("/delete.rp")
public class QnAReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAReplyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		request.setCharacterEncoding("UTF-8");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo);
		
		int result = new ReplyService().deleteReply(boardNo);
		HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "답변이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/qnaBoard?currentPage=1");
		}else {
			session.setAttribute("alertMsg", "답변 삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/");
		}

}
	
}

