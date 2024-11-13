package com.kh.board.controller.freeBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.board.model.service.CommentService;
import com.kh.board.model.service.FreeboardService;
import com.kh.board.model.service.ReplyService;
import com.kh.board.model.vo.Reply;

/**
 * Servlet implementation class FreeBoardReplyUpdateController
 */
@WebServlet("/update.frp")
public class FreeBoardReplyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardReplyUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		String content = request.getParameter("changed");
		
		request.setAttribute("rno", rno);
		request.setAttribute("content", content);
		
		int result = new ReplyService().updateFreply(rno,content);
		
		JSONObject jsonResponse = new JSONObject();
		response.setContentType("json/application;charset=UTF-8");
		
		if(result>0) {
			jsonResponse.put("status", "success");
		    jsonResponse.put("message", "댓글 수정에 성공하였습니다");
		}else {
			jsonResponse.put("status", "fail");
		    jsonResponse.put("message", "댓글 수정에 실패하였습니다");
		}
		
		response.getWriter().print(jsonResponse);
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
