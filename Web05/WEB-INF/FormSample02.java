package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formSample02")
public class FormSample02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//符号化されたパラメータをもとに元に戻すため、符号化形式を指定する
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータを取得する
		//String name = request.getParameter("部品名");
		//										↑　すごく大事
		String name = request.getParameter("name");
		
		//HTMLを出力する
		//「name」さん、こんにちは！
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>フォームサンプル02</title>");
		out.println("<head>");
		out.println("<body>");
		out.println("<p>「" + name + "」さん、こんにちは</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
