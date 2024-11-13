package com.kh.board.controller.freeBoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.FreeboardService;
import com.kh.board.model.service.ReplyService;

/**
 * Servlet implementation class FreeBoardReplyDeleteController
 */
@WebServlet("/delete.frp")
public class FreeBoardReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardReplyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int result = new ReplyService().deletefbReply(replyNo);
		 
		 HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "댓글이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/freeBoard?currentPage=1");
		}else {
			session.setAttribute("alertMsg", "댓글삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/");
		}
	
	
	}

}
