package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ReviewBoard;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;


@WebServlet("/detail/write")
public class DetailReviewWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService u=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/class/detailReview.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ReviewBoard board=new ReviewBoard();
		String r=req.getParameter("review");
		//System.out.println(r);
		board.setReviewContent(r);
		//System.out.println(board);
		u.insertReview(board);
		//System.out.println("넣음");
		
	}

}
