//ログイン情報を表すクラス

package model;

public class Login {

	/*--フィールド--*/
	private String userId;
	private String pass;
	
	/*--コンストラクタ--*/
	public Login(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	/*--アクセサ--*/
	public String getUserId() {
		return this.userId;
	}

	public String getPass() {
		return this.pass;
	}
	
	
}
