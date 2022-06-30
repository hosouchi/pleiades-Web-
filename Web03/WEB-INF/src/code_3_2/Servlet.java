package code_3_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//URLパターンを作成
@WebServlet("/Code3_2")

public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
		
		//ここからHTMLを記述
		response.setContentType("text/html; charset = UTF-8");	//レスポンスするデータの中身
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
		out.println("<head>");
		
		out.println("</head>");
		
		out.println("<body>");
		out.println("あいうえお");
		out.println("</body>");
		
		out.println("</html>");
		
	}
}
