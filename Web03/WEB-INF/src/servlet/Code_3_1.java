package servlet;

//3.サーブレット関係のクラスをインポートする
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//【サーブレットを動作させる時の設定】→URLパターンは/から始める
@WebServlet("/test")

//1.javax.servlet.http.HttpServletクラスを継承する
public class Code_3_1 extends HttpServlet {

	//2.doGetメソッドをオーバーライドする
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responce)throws ServletException,IOException {
		
		System.out.println("リクエストされました！");
		System.out.println("あああああ");
	}

}
