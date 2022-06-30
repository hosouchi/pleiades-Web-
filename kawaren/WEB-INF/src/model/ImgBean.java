package model;

import java.io.Serializable;

public class ImgBean implements Serializable {

	/*--フィールド--*/
	private String filename;	//画像のファイル名、yyyy-MM-dd-HH-mm-ss.jpgの形式で表現
	private String cont;		//投稿者
	private String comment;		//コメント
	private byte[] imgdata;		//画像の生データ（byte[]型データ）として用意するパターン
	
	/*--コンストラクタ--*/
	
	//引数なしコンストラクタ
	public ImgBean() {}

	//引数ありのコンストラクタ
	public ImgBean(String filename, String cont, String comment, byte[] imgdata) {
		this.filename = filename;
		this.cont = cont;
		this.comment = comment;
		this.imgdata = imgdata;
	}

	//ファイル名と投稿者名とコメントの3つでインスタンスが作成できるようにする
	public ImgBean(String filename, String cont, String comment) {
		
		//引数の3つのデータとnullの4つめのデータを指定して、「引数4つのコンストラクタ」を利用している
		this(filename , cont , comment , null);
	}

	/*--アクセサ--*/
	public String getFilename() {
		return filename;
	}

	public String getCont() {
		return cont;
	}

	public String getComment() {
		return comment;
	}

	public byte[] getImgdata() {
		return imgdata;
	}
}
