package ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		
		//アプリケーションスコープに保存するFruitインスタンス生成
		Fruit fruit = new Fruit("いちご",700);
		
		//ServletContextのインスタンス取得
		ServletContext application = this.getServletContext();
		
		//アプリケーションスコープにFruitインスタンスを保存
		application.setAttribute("fruit", fruit);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ex/fruit.jsp");
		dispatcher.forward(request, response);
		
	}
}
