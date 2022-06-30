//accountテーブルを担当するDAO

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	//データベース接続に使用する情報
	private static final String JDBC_URL = "jdbc:postgresql:sukkirishop";
	private static final String DB_USER = "postgres";
	private static final String DB_PASS = "postgres";
	
	//ドライバの有無を確認する
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("ドライバないよ");
		}
	}
	
	/*--メソッドを書いていく--*/
	public static Account findByLogin(Login login) {
		Account account = null;
	
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL , DB_USER , DB_PASS)){
		
			//select文を準備
			String sql = "select user_id , pass , mail , name ,age from account where user_id = ? and pass = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//ひな形へ値を流し込む
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			//select文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			//user_idは主キー　→　つまり1件取得もしくは0件取得のどちらかしかありえない
			if(rs.next()) {
				
				//もしも一致したユーザーがいたら→アカウントインスタンスを生成
				String userId = rs.getString("user_id");
				String pass = rs.getString("pass");
				String mail = rs.getString("mail");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				account = new Account(userId,pass,mail,name,age);
			}
		}catch(SQLException e) {
			//例外が発生したら、うまく検索できなかったことになるのでnullを返す
			e.printStackTrace();
			return null;
		}
		
		//もしも、レコードが見つかったらインスタンスが格納されている。見つからなかったらnullが格納されている
		return account;
	}
}
