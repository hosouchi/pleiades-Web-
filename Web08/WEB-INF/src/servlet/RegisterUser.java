package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		
		//入力フォームへフォワードする
		String forwardPath = null;
		
		//リクエストパラメター「action」の値を取得する
		String action = request.getParameter("action");
		
		//登録開始をリクエストされた時の処理
		if(action == null) {
			
			//フォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}else if(action.equals("done")){
			//ユーザー登録処理
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			
			//セッションスコープからUserインスタンスを削除
			session.removeAttribute("registerUser");
			
			//完了画面へフォワードする
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
			
		}
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		
		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//登録するユーザーの情報を設定
		User registerUser = new User(id,name,pass);
		
		//セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		
		dispatcher.forward(request, response);
	}
}
