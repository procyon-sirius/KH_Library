package com.kh.board.controller.commentBoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.board.model.service.CommentService;

/**
 * Servlet implementation class CommentUpdateController
 */
@WebServlet("/update.cm")
public class CommentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateController() {
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
		int rno = Integer.parseInt(request.getParameter("rno"));
		String content = request.getParameter("content");
		
		int result = new CommentService().updateComment(rno,content);
		
		JSONObject jsonResponse = new JSONObject();
		response.setContentType("json/application;charset=UTF-8");
		
		if(result>0) {
			jsonResponse.put("status", "success");
		    jsonResponse.put("message", "코멘트 작성에 성공하였습니다");
		}else {
			jsonResponse.put("status", "fail");
		    jsonResponse.put("message", "코멘트 작성에 실패하였습니다");
		}
		
		response.getWriter().print(jsonResponse);
	}

}
