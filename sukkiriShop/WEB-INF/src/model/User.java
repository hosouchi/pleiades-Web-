//ユーザー登録情報を表すクラス

package model;

public class User {

	/*--フィールド--*/
	private String userId;
	private String pass;
	private String email;
	private String name;
	private int age;
	
	/*--コンストラクタ--*/
	public User() {};
	
	public User(String userId, String pass, String email, String name, int age) {
		
		this.userId = userId;
		this.pass = pass;
		this.email = email;
		this.name = name;
		this.age = age;
	}

	/*--アクセサ--*/
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
