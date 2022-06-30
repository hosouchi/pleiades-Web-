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

import model.Hero;

// テキトーなArrayList<HeroBean>インスタンスからJSONデータを生成し、ダウンロードさせてくれるWebAPIとなるサーブレット
@WebServlet("/json")
public class JsonDownloadServ extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		// ArrayList<Hero>インスタンス生成…本来なら、このデータはデータベースなどからもらってきたデータで作成することになる。今回は簡単の為に、この場で生成しちゃう
		Hero h1 = new Hero("ミナト", 50, 10);
		Hero h2 = new Hero("アサカ", 100, 50);
		Hero h3 = new Hero("クラウド", 500, 150);
		Hero h4 = new Hero("セフィロス", 750, 250);
		
		ArrayList<Hero> heroes = new ArrayList<>();
		heroes.add(h1);
		heroes.add(h2);
		heroes.add(h3);
		heroes.add(h4);
		
		// GSONライブラリを導入（gson-2.9.0.jarをビルドパスに通し、/WEB-INF/libにもコピー）し、一発変換
		Gson gson = new Gson();
		String jsonHeroes = gson.toJson(heroes);
		
		// 確認：JSONデータをコンソールに出力してみる。これが出来たら、レスポンスとして接続元に提供
//		System.out.println(jsonHeroes); ⇒確認OK
		
		res.setContentType("application/json;charset=UTF-8");	// JSONダウンロード用のMIMEタイプ指定
		PrintWriter out = res.getWriter();						// 文字列用の出力ストリームです。
		out.println(jsonHeroes);
	}
}
