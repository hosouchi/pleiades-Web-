package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dice;
import model.DiceLogic;

@WebServlet("/DiceServlet")
public class DiceServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//リクエストパラメーター取得処理はなくてよし
		List<Dice> dices = DiceLogic.execute();
		
		//今までふったサイコロ情報をスコープへ保存する
		//リクエストスコープへ保存すると、index.jspからサイコロ情報を取得できない。
		//個人で楽しみたいから（色々な人に見られたくないから）アプリケーションスコープは使えない。→セッションスコープを使用
		HttpSession session = req.getSession();
		session.setAttribute("dices", dices);
		
		//フォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/diceresult.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	

}
