package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URLパターンを作成
@WebServlet("/dice")

public class servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		
		/*--ここからJavaを記述--*/
		
		//1-6の乱数を3つ発生させる
		int dice1 = new java.util.Random().nextInt(6);
		int dice2 = new java.util.Random().nextInt(6);
		int dice3 = new java.util.Random().nextInt(6);
		
		//運勢メッセージと回数の表示用関数
		String msg = null;
		int count = 1;	
		
			//3つのサイコロが1以外の時にループさせる
			while(!(dice1 == 1 && dice2 == 1 && dice3 == 1 )) {
				
				//変数の上書きを行って、もう一回ふる
				dice1 = new java.util.Random().nextInt(6)+1;
				dice2 = new java.util.Random().nextInt(6)+1;
				dice3 = new java.util.Random().nextInt(6)+1;
				
				//カウント表示用
				count++;
			}
			
			//ループを抜け、運勢表示用
			if(count<50) {
				msg = "ラッキー";
			}else if(count<100) {
				msg = "まぁまぁラッキー";
			}else if(count>200) {
				msg = "残念";
			}else {
				msg = "普通";
			}
		
		/*--ここからHTMLを記述--*/
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<div align = center>");
		
		out.println("<br>");
		out.println("3つのサイコロがすべて1になるまでにかかった回数は" + count + "回でした。");
		out.println("<br>");
		out.println("<br>");
		
		out.println("<font size =10 color = red>");
		out.println("あなたの運勢は" + msg );
		out.println("</font>");
		
//		out.println("<br>");
//		out.println("<img src = D:\\pleiades[Web]\\workspace\\renshu\\WEB-INF\\src\\Servlet\\watermelon.png alt = スイカ>");
		
		out.println("</div>");
		
		out.println("</body>");
		
		out.println("</html>");
	}
}
