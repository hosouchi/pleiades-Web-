package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EvMsgLogic;
import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//アプリケーションスコープに保存されたサイト評価を取得
		ServletContext application = this.getServletContext();
		SiteEV siteEV =(SiteEV) application.getAttribute("siteEV");
		
		//アプリケーションスコープから評価者メッセージを取得
		String evMsg = (String) application.getAttribute("evMsg");
		
		//初回リクエスト
		if(siteEV == null) {
			siteEV = new SiteEV();
		}
		if(evMsg == null) {
			evMsg = "";
		}
		
		//リクエストパラメーターを取得
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		//リクエストしたPCのIPアドレスを取得
		String ipAddr = req.getRemoteAddr();
		
		//サイトの評価処理およびメッセージ処理
		SiteEVLogic siteEVLogic = new SiteEVLogic();
		EvMsgLogic msgLogic = new EvMsgLogic();
		
		if(action !=null && action.equals("like")) {
			siteEVLogic.like(siteEV);
			evMsg = msgLogic.like(ipAddr, evMsg);
		}else if(action !=null && action.equals("unlike")) {
			siteEVLogic.unlike(siteEV);
			evMsg = msgLogic.unlike(ipAddr, evMsg);
		}
		
		//アプリケーションスコープにサイト評価を保存
		application.setAttribute("siteEV", siteEV);
		application.setAttribute("evMsg", evMsg);
		
		//フォワード
		RequestDispatcher dispatcher =req.getRequestDispatcher("/WEB-INF/jsp/minatoIndex.jsp");
		dispatcher.forward(req, resp);
	}
}
