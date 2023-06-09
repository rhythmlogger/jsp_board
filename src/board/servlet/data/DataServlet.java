package board.servlet.data;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.Comment;
import board.model.Data;
import board.model.Recommend;
import board.service.CommentService;
import board.service.DataService;
import board.service.RecommendService;

@WebServlet("/data")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		} else {
			RecommendService recommendService = new RecommendService();
			DataService dataService = new DataService();
			CommentService commentService = new CommentService();
			int num = Integer.parseInt(request.getParameter("num").toString());
			List<Comment> commentList = commentService.getList(num);
			dataService.hit(num);
			Data data = dataService.getData(num);
			int recommendTotal = recommendService.getRecommendTotal(num);
			Recommend recommend = recommendService.isRecommendById(num, session.getAttribute("id").toString());
			request.setAttribute("recommendTotal", recommendTotal);
			request.setAttribute("data", data);
			request.setAttribute("recommend",recommend);
			request.setAttribute("commentList", commentList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/data.jsp");
			dispatcher.forward(request, response);
		}

	}

}
