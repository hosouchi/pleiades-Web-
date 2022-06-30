package servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ImgDAO;
import model.ImgBean;

@WebServlet("/imgupload")

//文字列と画像データの混合リクエストパラメーター（マルチパートデータ）処理。locationは一時保存先。maxFileSizeが最大容量。
@MultipartConfig(location="d:\\images",maxFileSize=1*1024*1024*10)	//1バイトの1024倍が1KB。1kbの1024倍が1MB。*10で「10MB」

public class ImgUlServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//フォワード
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/imgul.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String cont = req.getParameter("cont");
		String comment = req.getParameter("comment");
		//System.out.println(cont + ":" + comment);
		
		//アップロードされた瞬間の何月日時分秒（LocalDateTimeインスタンス）から、ファイル名（文字列：yyyy-MM-dd-HH-mm-ss.jpg）をつくる
		
		//LocalDateTimeインスタンスを文字列にするには、DateTimeFormatterインスタンスが必要
		LocalDateTime now = LocalDateTime.now();		//現在の日時を取得
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		String imgFilename = now.format(fmt) + ".jpg";
		System.out.println("アップロードされた画像ファイルの名前" + imgFilename);
		
		//画像データをリクエストパラメーターから取得...Partインスタンスという形で取得することになる
		Part imgPart = req.getPart("imgfile");
		
		//一時保存先フォルダにPartオブジェクトとして取得した画像を保存してみる→デバックコードの役目御免
		//imgPart.write(imgFilename);
		
		//ここまで動いたら、あとはPartインスタンスからbyte[]データ（生の画像データ）を取得する
		
		//Partインスタンスから入力ストリームを取得し、場合によっては便利なフィルタをつけつつ、
		//1バイトずつ書き込み、ため込んで、後でまとめてbyte[]型データに変換してくれる出力ストリーム
		try(
				InputStream is = imgPart.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
		){
			//Partインスタンスの入力ストリームから1バイトずつデータ読み込み
			//→ByteArrayOutputStreamインスタンスに書き込み・・・画像データがなくなるまで繰り返し
			int b;	//画像の1バイト分のデータを仮に保管しておく変数
			while((b = bis.read()) != -1){
				baos.write(b);
			}
			
			//繰り返しが終了したら、溜め込んだ画像データをbyte[]型データに一発変換
			byte[] imgdata = baos.toByteArray();
			
			//ファイル名、投稿者名、コメント、画像のbyte[]データでImgBeanインスタンスを作り
			ImgBean ibean = new ImgBean(imgFilename, cont, comment, imgdata);
			
			//ImgDAOのinsertImg()メソッドに渡す→データベースに保存
			ImgDAO.insertImg(ibean);
		}
		//ここでcatchを書かなくていい理由はIOException（例外）はtomcatのほうで処理を行ってくれるからOK
		
		//全投稿をリストとして表示するために、ImgUploader/all　にリダイレクト処理を行う
		resp.sendRedirect("/kawaren/all");
	}
}
