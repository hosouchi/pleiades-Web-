//ログインに関するリクエストを処理するコントローラー

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("LoginServletのdoGet()メソッドが呼ばれました");→OK
		
		//もし、セッションスコープにuserIdという属性が存在しなければ、未ログイン状態→ログインページへ
		if(req.getSession().getAttribute("userId") == null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(req, resp);
			
		}else {	//もしそうでないならば、ログイン状態→ログインOKページへ
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("LoginServletのdoGet()メソッドが呼ばれました");→OK
		
		//リクエストパラメーターの取得
		req.setCharacterEncoding("UTF-8");
		String userId = req.getParameter("userid");
		String pass = req.getParameter("pass");
		//System.out.println("ユーザーID：" + userId + "パスワード：" + pass);
		
		//データベースに登録されたユーザーアカウントと同一かをチェック→ログイン処理の実行
		Login login = new Login(userId,pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		//System.out.println("ログインできましたか？：" + result);
		
		/*--ログイン処理の成否によって処理を分岐--*/
		
		//ログイン成功時
		if(result) {	
			
			//入力パラメーターはログインできた→その証にユーザーＩＤをセッションスコープに保存→ログイン状態を維持
			HttpSession session = req.getSession();
			session.setAttribute("userId", userId);	//このシステムではユーザー名のみの保存。
			
			//フォワード
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(req, resp);
	
		//ログイン失敗時
		}else {
			resp.sendRedirect("/sukkiriShop/LoginServlet");	//ログインやりなおし
//			RequestDispatcher dispatcher = req.getRequestDispatcher("//LoginServlet");
//			dispatcher.forward(req, resp);
		}
	}

}
