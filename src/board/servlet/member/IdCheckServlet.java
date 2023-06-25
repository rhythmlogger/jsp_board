	package board.servlet.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Member;
import board.service.MemberService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/id-check")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id").toString();
		MemberService memberService = new MemberService();
		memberService.idCheck(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/id-check.jsp");
		request.setAttribute("result", memberService.idCheck(id));
		dispatcher.forward(request, response);
	}

}
