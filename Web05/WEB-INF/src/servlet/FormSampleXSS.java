package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formXSS")
public class FormSampleXSS extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request , HttpServletResponse response)
		throws ServletException,IOException{
		
		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String comment = request.getParameter("comment");
		
		//commentに含まれている[<]→[&lt]、[>]→[&gt]
		//サニタイジングと呼ばれている
		comment = comment.replace("<", "&lt").replace(">", "&gt");
		
		
		//表示メッセージ生成
		String msg = "入力値＝" + comment;
				
		//HTML出力
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>XSSテスト</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println(msg);
		out.println("</body>");
		
		out.println("</html>");
	}
}
