package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cnt2")
public class CounterServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//訪問回数を表示
		ServletContext application = this.getServletContext();
		Integer cnt = (Integer)application.getAttribute("cnt");
		
		//訪問回数を1加算して、保存する
		cnt++;
		application.setAttribute("cnt", cnt);
		
		//訪問回数出力
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>訪問回数を表示</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>訪問回数:" + cnt + "</h1>");
		out.println("<h2>(リスナーver)</h2>");
		out.println("<a href = \"/Web11/cnt2\">更新</a>");
		out.println("</body>");
		
		out.println("</html>");
	}
}
