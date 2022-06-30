package servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImgDAO;

//このサーブレットはhttp://localhost:8080/kawaren/imgdownload?filename=9999-99-99-99-99-99.jpgで起動される
@WebServlet("/imgdownload")
public class ImgDlServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//リクエストパラメーター：filenameを取得・・・DBに登録された画像のファイル名
		String filename = req.getParameter("filename");
		System.out.println("リクエストされたファイル名は" + filename);
		
		//ImgDAO#selectImg()の実引数にファイル名を指定し、その画像データ(byte[]データ)をもらう
		byte[] imgdata = ImgDAO.selectImg(filename);
		
		//バイナリーデータ出力用をもらい
		try(
			ServletOutputStream sos = resp.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(sos);
				
		){
			//画像のbyte[]データを流し込む→レスポンスとしてクライアントに届く
			bos.write(imgdata);
			bos.flush();	//今までのデータをすぐにはきだし
			bos.close();	//close忘れないようにする
		}
		
	}

}
