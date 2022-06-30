package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
//ログイン画面からのリクエスト方法は、POSTのためdoPost()を実装する
	//なぜGETだめなの？→URLにリクエストパラメーターが表示される→今回表示されるものはユーザー名とパスワード
	//誰かに見られたら不正アクセスされるため

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ログインしようとしているのが誰なのか取得する（リクエストパラメーター）
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		//Userインスタンスを取得する
		User user = new User(name,pass);
		
		//このuserが会員登録されているのか確認する
		LoginLogic logic = new LoginLogic();
		boolean isLogin = logic.execute(user);		//パスワードが1234ならtrue,それ以外ならfalse
		
		if(isLogin) {
			//登録済みユーザーであるため、セッションスコープへ保存する
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
		}
		
		//ログイン結果画面へフォワードする
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	

}
