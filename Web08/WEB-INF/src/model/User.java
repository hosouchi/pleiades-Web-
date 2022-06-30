package model;

import java.io.Serializable;

public class User implements Serializable{

	/*--フィールド--*/
	private String id;		//ID
	private String name;	//名前
	private String pass;	//パスワード
	
	/*--コンストラクタ--*/
	
	public User() {}
	public User(String id, String name,String pass) {
		this.setId(id);
		this.setName(name);
		this.setPass(pass);
	}
	
	/*--アクセサ--*/
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
