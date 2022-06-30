//自己紹介（名前・出身地・趣味を記述）

package model;

import java.io.Serializable;

public class Person implements Serializable {

	/*--フィールド--*/
	private String name;	//名前
	private String from;	//出身地
	private String hobby;	//趣味
	
	/*--コンストラクタ--*/
	public Person() {};
	
	public Person(String name, String from, String hobby) {
		this.name = name;
		this.from = from;
		this.hobby = hobby;
	}
	
	/*--アクセサ--*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
