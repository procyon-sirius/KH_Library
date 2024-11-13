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
 * Servlet implementation class CommentInsertController
 */
@WebServlet("/insert.cm")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		int writerNo = Integer.parseInt(request.getParameter("writerNo"));
		String comment = request.getParameter("comment");
		
		JSONObject jsonResponse = new JSONObject();
		response.setContentType("json/application;charset=UTF-8");
		int boardN = new CommentService().selectClist(bookNo);
		
		// 보드 유무 확인 
		if(boardN>0) {
			int commentR = new CommentService().createReply(boardN,writerNo,comment);
			
			// 보드 유 > 코멘트 생성
			if(commentR>0) {
				  jsonResponse.put("status", "success");
			      jsonResponse.put("message", "코멘트 작성에 성공하였습니다");
			}else {
				jsonResponse.put("status", "fail");
			    jsonResponse.put("message", "코멘트 작성에 실패하였습니다");
			}
		}else {
			// 보드 무 > 보드 생성 > 코멘트 생성
			int commentB = new CommentService().createComment(bookNo,writerNo);
			
			if(commentB>0) {
				
				int commentR = new CommentService().createReply(boardN,writerNo,comment);
				
				if(commentR>0) {
					 jsonResponse.put("status", "success");
				     jsonResponse.put("message", "코멘트 작성에 성공하였습니다");
					
				}else {
					jsonResponse.put("status", "fail");
				    jsonResponse.put("message", "코멘트 작성에 실패하였습니다");
				}
				
			}else {
				jsonResponse.put("status", "fail");
			    jsonResponse.put("message", "게시판 생성에 실패하였습니다");
			}
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
