//ログイン処理を担当するBO

package model;

import dao.AccountDAO;

public class LoginLogic {

	public boolean execute(Login login) {
		
		//テキストではDAOをインスタンス生成しているが、各メソッドはstaticキーワード付なので、クラス名.メソッド名で呼べる
		//基本フィールドをもたないクラスはインスタンス化する意味がない。「共通概念」とか「公式」みたいなものがそれ
		Account account = AccountDAO.findByLogin(login);
		
		//returnしているのは、accountがnullかどうかのboolean型データ...accountの中身はnullではない。yes? or no?
		return account != null;
	}
}
