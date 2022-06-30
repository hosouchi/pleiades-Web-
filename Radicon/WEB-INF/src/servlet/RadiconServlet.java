package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Radix;
import model.RadixLogic;

@WebServlet("/radiconservlet")
public class RadiconServlet extends HttpServlet {

	private final static long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException,IOException{
		
		//入力フォームへフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/radiconForm.jsp");	//転送先を指定
		
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
		
		//リクエストパラメーターを取得する
		request.setCharacterEncoding("UTF-8");
		String decimal = request.getParameter("decimal");
		
		try {
			//Radixインスタンスを生成
			int decimal_int = Integer.parseInt(decimal);
			Radix radix = new Radix(decimal_int);
			
			//2.8.16進数フィールドの値をセットする
			RadixLogic.calcRadix(radix);
			
			//radixインスタンスをリクエストスコープへ保存する
			request.setAttribute("radix", radix);
		}catch(NumberFormatException e) {
			
			//エラーメッセージ作成
			String errMsg = decimal + "は数字ではありません";
			
			//エラーメッセージをリクエストスコープへ保存する
			request.setAttribute("errMsg", errMsg);
		}
		
		//結果
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/radiconResult.jsp");
		dispatcher.forward(request, response);
		
	}
}
