package prefsServlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URLパターンを作成
@WebServlet("/prefs")

public class prefsRead extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
		System.out.println("サーブレット動作しました");
		
		/*--ここからjava--*/
		
		//ファイルの読み込み処理を開始
		String path = "D:\\pleiades[Web]\\workspace\\renshu\\prefs.csv";
		
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String data;
		
		/*--ここからHTML--*/
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.print("<table border = 1 color = red>");
		out.print("<tr>");
		out.print("<th>コード</th>");
		out.print("<th>地名</th>");
		out.print("<th>県名</th>");
		out.print("<th>県庁所在地</th>");
		out.print("<th>面積</th>");
		out.print("</tr>");
		
		while((data = br.readLine()) != null) {
			
			String[] str = data.split(",");
			out.print("<tr>");
			
			out.print("<td>");
			out.print(str[0]);
			out.print("</td>");
			
			out.print("<td>");
			out.print(str[1]);
			out.print("</td>");
			
			out.print("<td>");
			out.print(str[2]);
			out.print("</td>");
			
			out.print("<td>");
			out.print(str[3]);
			out.print("</td>");
			
			out.print("<td>");
			out.print(str[4]);
			out.print("</td>");
			
			out.print("</tr>");
		}
		br.close();
		
		out.println("</table>");
		out.print("</body>");
		out.println("</html>");
		
		
	}

}
