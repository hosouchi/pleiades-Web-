package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//セッション破棄
		HttpSession session = req.getSession();
		session.invalidate();
		
		//ログアウト画面へフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/logout.jsp");
		dispatcher.forward(req, resp);
	}
}
