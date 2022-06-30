package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URL設定
@WebServlet("/formSample02")
public class FormSample02 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		
		//符号化されたパラメーターをもとに戻すため、符号化形式を指定する
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメーターを取得
		//String name = request.getParameter("部品名");
		String name = request.getParameter("name");
		
		//HTMLを出力する
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		
		out.println("</head>");
		
		out.println("<body>");
		
		out.println( name + "さんこんにちは");
		
		out.println("</body>");
		
		out.println("</html>");
		
		
		
		
		
	}

}
