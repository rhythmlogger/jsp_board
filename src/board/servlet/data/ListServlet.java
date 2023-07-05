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

import board.model.Data;
import board.service.DataService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		} else {
			DataService dataService = new DataService();
			Object numObject = request.getParameter("num");
			int num;
			if (numObject != null) {
				num = Integer.parseInt(numObject.toString());
			} else {
				num = 1;
			}
			List<Data> list = dataService.getList((num - 1) * 5, 5);
			request.setAttribute("list", list);
			request.setAttribute("count", dataService.count());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
		}
	}

}
