package board.servlet.comment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Comment;
import board.service.CommentService;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num").toString());
		String contents = request.getParameter("contents").toString();
		String id = request.getParameter("id").toString();
		Comment comment = new Comment(num, id, contents);
		CommentService commentService = new CommentService();
		if (commentService.insert(comment) > 0) {
			response.sendRedirect("/data?num=" + num);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/write.jsp");
			dispatcher.forward(request, response);
		}
	}
}
