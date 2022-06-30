package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ImgDAO;
import model.ImgBean;

@WebServlet("/json") 
public class JsonDlServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//　DAOに全権抽出⇒ArrayList<ImgBean>インスタンスを返してくれるメソッドのコール
		ArrayList<ImgBean> list = ImgDAO.selectAll();
		
		//　ArrayList<ImgBean>をJsonデータに変換（GSONライブラリを事前にビルドパス登録。WEB/INF/libの中にもコピー）
		Gson gson = new Gson(); 
		String json = gson.toJson(list);
		
		//　文字列出力ストリームに書き出し
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(json);
		
	}
}
