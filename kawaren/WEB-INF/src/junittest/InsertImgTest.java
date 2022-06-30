package junittest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import dao.ImgDAO;
import model.ImgBean;

class InsertImgTest {

	@Test
	public void testBeanInsrt() {
		
		//4つのダミーデータを用意して
		String filename = "9999-99-99-99-99-98.jpg";
		String cont = "ダミーの投稿者";
		String comment = "ダミーのコメント";
		
		//ダミーの画像を用意...Windowsの適当な写真を使用
		
		/*--参照ライブラリにビルドパスを通す--*/
		//1.Pathインスタンスにする(java実践編のp221を参照)
		Path p1 = Paths.get("C:\\Windows\\Web\\Screen\\img100.jpg");
		try {
		
			byte[] imgdata = Files.readAllBytes(p1);
			System.out.println("画像ファイルのサイズ：" + imgdata.length + "バイト");
			
			//ImgBeanインスタンスを作って
			ImgBean ibean = new ImgBean(filename,cont,comment,imgdata);
			
			//DAOのデータ保存メソッドに渡してテスト→trueが返ってくるはず
			boolean kekka = ImgDAO.insertImg(ibean);
			assertTrue(kekka == true);
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}

}
