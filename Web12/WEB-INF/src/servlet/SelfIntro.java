//自己紹介に関するリクエストを処理するコントローラー

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

@WebServlet("/selfintro")
public class SelfIntro extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//フォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/SelfIntroForm.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//リクエストパラメーターを取得
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name"); 	//名前
		String from = req.getParameter("from");		//出身地
		String hobby = req.getParameter("hobby");	//趣味
		
		//入力値をプロパティに設定
		Person person = new Person();	//personインスタンス生成
		person.setName(name);
		person.setFrom(from);
		person.setHobby(hobby);
		
		//リクエストスコープに保存
		req.setAttribute("person", person);
		
		//フォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/SelfIntroHello.jsp");
		dispatcher.forward(req, resp);
		
	}
}
