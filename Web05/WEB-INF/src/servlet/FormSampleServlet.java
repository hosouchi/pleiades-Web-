package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//URL設定。パラメーターの送信先と揃えないといけない。
@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		
		//STEP1：リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		//STEP2：出力メッセージ生成
		String msg = this.responseMsg(name, gender);
		
		//STEP3：HTMLを記述
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<meta charset=UTF-8>");
		out.println("<title>ユーザー登録結果</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println(msg);
		out.println("</body>");
		
		out.println("</html>");
	}
	
	private String responseMsg(String name ,String gender) {
		String msg = "";
		if(name == null || name.length() == 0) {
			msg += "名前が入力されていません";
		}
		
		if(gender == null || gender.length() == 0) {
			msg += "性別が選択されていません";
		}else {	//性別が0だった時は男性
			if(gender.equals("0")) {	
				gender = "男性";
			}else if(gender.equals("1")) {
				gender = "女性";
			}
		}
		
		if(msg.length() != 0) {
			return msg;
		}
		return name + "さん(" + gender + ")を登録しました"; 
	}

}
