package model;

import java.io.Serializable;

public class SiteEV implements Serializable{
	
	/*--フィールド--*/
	private int like;	//いいねの数
	private int unlike;	//よくないねの数
	
	/*--コンストラクタ--*/
	public SiteEV() {
		this.like=0;
		this.unlike=0;
	}

	/*--アクセサ--*/
	public int getLike() {
		return this.like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getUnlike() {
		return this.unlike;
	}

	public void setUnlike(int unlike) {
		this.unlike = unlike;
	}
	
	
	

}
