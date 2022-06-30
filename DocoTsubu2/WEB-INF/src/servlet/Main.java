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

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.SearchLogic;
import model.User;



@WebServlet("/Main")
public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//リクエストパラメーターを取得
		req.setCharacterEncoding("UTF-8");
		String text = req.getParameter("text");
		
		List<Mutter> mutterList;
		if(text == null || text.length()== 0) {
			//つぶやきリストの全てをデータベースから取得して、リクエストスコープへ保存する
			GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
			mutterList = getMutterListLogic.execute();
		}else {
			//検索結果つぶやきリストを取得
			SearchLogic searchLogic = new SearchLogic();
			mutterList = searchLogic.execute(text);
		}
		
		//つぶやきリストをリクエストスコープへ保存
		req.setAttribute("mutterList", mutterList);
		
		//ログインしているか確認する
		//ログインしていたら、セッションスコープからUserインスタンスが取得できるはずだ。ログインしていなかったらnullとなるはずだ
		
		HttpSession session = req.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			
			//ログインしていないのならば
			resp.sendRedirect("/DocoTsubu2/");
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
//			ServletContext application = this.getServletContext();
//			List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
			
			//誰がつぶやいたのか
			HttpSession session = req.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			
			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
		}else {
			//エラーメッセージをリクエストスコープへ保存する
			//textがnullもしくはtextが空文字だったら
			String errMsg = "つぶやきが入力されていません";	//エラーメッセージ生成
			req.setAttribute("errMsg", errMsg);			//エラーメッセージをリクエストスコープへ保存
		}
		
		//つぶやきリストを取得して、リクエストスコープへ保存する
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		req.setAttribute("mutterList", mutterList);
		
		
		//メイン画面へフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(req, resp);
	}
}
