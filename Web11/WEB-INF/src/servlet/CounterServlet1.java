package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cnt1")
public class CounterServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/*--サーブレットインスタンスが作成される際、1回だけ実行--*/
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//訪問回数は色々な人に見てもらいたいとなると初期化した訪問回数をどのスコープへ保存する？→アプリケーションスコープ
		
		//1.訪問回数0のインスタンスを生成するラッパークラスを使用する
		Integer count = 0;
		
		//2.アプリケーションスコープへ保存する
		ServletContext application = this.getServletContext();
		application.setAttribute("count", count);
		
		//本当に1回だけか怪しいため、コンソールアウトする
		//nowStrにyyyy/MM/dd hh:mm:ss 形式の現在時刻を代入
		Date now = new Date();												//1.Dateインスタンスを生成
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");	//2.Dateインスタンスを文字列へ変換するインスタンスを生成
		String nowStr = sdf.format(now);									//3. 2のメソッドを使用して、1のインスタンスを文字列へ変換
		System.out.println(nowStr + "init()が実行されました");
		
	}
	
	/*--GETリクエストされるたび--*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//訪問回数を1増やしたい
		
		//現在の訪問回数を取得（アプリケーションスコープに保存されている）
		ServletContext application = this.getServletContext();
		Integer count = (Integer)application.getAttribute("count");
		
		//訪問回数に1を加える
		count++;
		
		//最新の訪問回数を保存
		application.setAttribute("count", count);
		
		//訪問回数をHTMLで出力
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>訪問回数を表示</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>訪問回数:" + count + "</h1>");
		
		out.println("<a href = \"/Web11/cnt1\">更新</a>");
		out.println("</body>");
		
		out.println("</html>");
		
	}

	/*--サーブレットインスタンスが破棄される際、1回だけ実行--*/
	@Override
	public void destroy() {
		
		//本当に1回だけか怪しいため、コンソールアウトする
		//nowStrにyyyy/MM/dd hh:mm:ss 形式の現在時刻を代入
		Date now = new Date();												//1.Dateインスタンスを生成
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");	//2.Dateインスタンスを文字列へ変換するインスタンスを生成
		String nowStr = sdf.format(now);									//3. 2のメソッドを使用して、1のインスタンスを文字列へ変換
		System.out.println(nowStr + "destroy()が実行されました");
	}
}
