//=================================================
//ログインしようとしているユーザーが登録されているか確認を行うクラス
//=================================================

package model;

public class LoginLogic {
	
	//　引数：ログインしようとしているユーザー情報
	//　戻り値：ログイン成功→true ログイン失敗→false
	
	public boolean execute(User user) {
	
		//もしも、userのパスワードが1234ならば成功
		if(user.getPass().equals("1234")) {
			return true;
		}
		
		//userのパスワードが1234でなかったらログイン失敗
		return false;
	}

}
