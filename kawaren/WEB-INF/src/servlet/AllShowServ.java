package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImgDAO;
import model.ImgBean;

@WebServlet("/all")
public class AllShowServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ImgDAO #selectAll()をコールし、ArrayList<ImgBean>インスタンスをもらう
		ArrayList<ImgBean> list = ImgDAO.selectAll();
		
		//ArrayList<imgBean>インスタンスをリクエストスコープに属性名「list」で保存し
		req.setAttribute("list", list);
		
		//showall.jspへフォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/showall.jsp");
		dispatcher.forward(req, resp);
		
	}
}
