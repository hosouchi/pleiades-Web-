//=================================================
//一行のつぶやきをあらわすクラス
//=================================================

package model;

import java.io.Serializable;

public class Mutter implements Serializable {

	/*--フィールド--*/
	private int id;					//id
	private String userName;		//ユーザー名
	private String text;			//つぶやき内容
	
	/*--コンストラクタ--*/
	public Mutter() {}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	
	/*--アクセサ--*/
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
