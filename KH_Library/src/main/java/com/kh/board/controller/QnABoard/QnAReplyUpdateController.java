package com.kh.board.controller.QnABoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.NoticeService;
import com.kh.board.model.service.ReplyService;

/**
 * Servlet implementation class QnAReplyUpdateController
 */
@WebServlet("/update.rp")
public class QnAReplyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAReplyUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String content = new ReplyService().selectRconent(boardNo);
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("content", content);
		request.getRequestDispatcher("/views/board/QnABoard/qnaReplyUpdateForm.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("content");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		int result = new ReplyService().updateReply(boardNo, content);

		
		String alertMsg = "";
		if(result>0) {
			alertMsg = "문의 글 답변을 수정하였습니다.";
		}else {
			alertMsg = "문의 글 답변을 수정하지못했습니다.";
		}
		
		request.getSession().setAttribute("alertMsg", alertMsg);
		response.sendRedirect(request.getContextPath()+"/qnaBoard?nno="+boardNo);
		
	
	
	}

}
