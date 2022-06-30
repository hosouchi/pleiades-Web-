package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;



@WebServlet("/Main")
public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//つぶやきリストをアプリケーションスコープから取得
		//初回リクエストなら、インスタンスが存在しない→nullのこと
		
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
		
		if(mutterList == null) {
			//つぶやきリストが存在しなかったら、空っぽのつぶやきリストを取得
			mutterList = new ArrayList<Mutter>();
			//スコープへ保存
			application.setAttribute("mutterList", mutterList);
		}
		
		//ログインしているか確認する
		//ログインしていたら、セッションスコープからUserインスタンスが取得できるはずだ。ログインしていなかったらnullとなるはずだ
		
		HttpSession session = req.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			
			//ログインしていないのならば
			resp.sendRedirect("/DocoTsubu");
		}else {
			//ログインしていたら
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//つぶやき内容を取得
		req.setCharacterEncoding("UTF-8");
		String text = req.getParameter("text");
		
		//入力値チェック
		if(text !=null && text.length() != 0) {
			
			//テキストがnullではなく、空文字でもなかったら・・・
			//アプリケーションスコープからつぶやきリストを取得する
			ServletContext application = this.getServletContext();
			List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
			
			//誰がつぶやいたのか
			HttpSession session = req.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			//誰がどんなつぶやきをしたのかを表すMutterインスタンスを生成する
			Mutter mutter = new Mutter(loginUser.getName(),text);
			
			//つぶやきリストへ最新の投稿を追加する
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);
			
			//最新の投稿が追加されたつぶやきリストをアプリケーションスコープへ保存する
			application.setAttribute("mutterList", mutterList);
		}else {
			//textがnullもしくはtextが空文字だったら
			String errMsg = "つぶやきが入力されていません";	//エラーメッセージ生成
			req.setAttribute("errMsg", errMsg);			//エラーメッセージをリクエストスコープへ保存
		}
		
		//メイン画面へフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
}
