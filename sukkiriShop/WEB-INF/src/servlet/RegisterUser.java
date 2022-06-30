//ユーザー登録に関するリクエストを処理するコントローラー

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//フォワード先
		String forwardPath = null;	//いつどこでフォワードするか分からないから
		
		//doGet内の処理をリクエストパラメーターの「action」の値をリクエストパラメーターから取得する
		//actionが「null→ユーザー登録画面の表示」「done→ユーザー登録実行処理」といった形で振り分ける
		String action = req.getParameter("action");
		
		//「ユーザー登録開始をリクエストされた時」
		if(action == null) {
			//フォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}
		
		//登録確認画面から「登録実行リクエスト」された時の処理
		else if(action.equals("done")) {
			
			//セッションスコープに保存された登録ユーザーを取得する
			HttpSession session = req.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			
			//登録処理の呼び出し
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			
			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");
			
			//登録後のフォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}
		
		//設定されたフォワード先にフォワード
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
