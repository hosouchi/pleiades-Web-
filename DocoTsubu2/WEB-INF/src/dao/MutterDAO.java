package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	//データベース接続に必要な情報
	//どのデータベースへ
	//どのユーザーが接続するのか
	//そのユーザーのパスワードは何なのか
	//定数は大文字→暗黙の了解
	private final String JDBC_URL = "jdbc:postgresql:docotsubu";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "postgres";
	
	//JDBCドライバの有無を確認する
	//1回だけ実行する
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバが配置されていません");
		}
	}

	/*---------------------------------------*/
	//		検索処理一覧
	//			findAll
	//			findContainText
	/*---------------------------------------*/
	//つぶやきを全て取得するメソッド
	//メソッド名：findAll 全て見つけるから
	//引数：不要
	//戻り値：List<Mutter>
	public List<Mutter> findAll() {
		//戻り値となるListを宣言しておく
		List<Mutter> mutterList = new ArrayList<Mutter>();
		try(
				//STEP1:接続
				Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		) {
			//STEP2-1:SQL文のひな形作成
			String sql = "SELECT id, name, text FROM mutter ORDER BY id DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			//STEP2-2:ひな形に値を流す（今回は不要）
			//STEP2-3:SQL文送信 更新系と検索系でちょっと変わります
			ResultSet rs = pstmt.executeQuery();
			//次に行がある間ループしてね
			while(rs.next()) {
				//現在指し示しているレコードの値を取得する
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String text = rs.getString(3);
				//つぶやきインスタンス生成
				Mutter mutter = new Mutter(id, name, text);
				//つぶやきインスタンスをlistへ加える
				mutterList.add(mutter);
			}
			//STEP3:切断（try-with-resourcesを使うため不要）
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("つぶやきリスト取得できなかった。なんかコードに問題あるかもよ");
			return null;
		}
		return mutterList;	//正常に終了した場合はmuttetrListを返す
	}

	//渡された文字がtext列に含まれているレコード一覧を抽出する
	//メソッド名：findContainText
	//引数：検索したい文字列
	//戻り値：つぶやき一覧
	public List<Mutter> findContainText(String searchText) {
		List<Mutter> mutterList = new ArrayList<Mutter>();
		
		try(
				Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		) {
			String sql = "SELECT id, name, text FROM mutter WHERE text LIKE ? ORDER BY id DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchText + "%"); //SELECT id, name, text FROM mutter WHERE text LIKE '%いくら%'
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String text = rs.getString(3);
				
				Mutter mutter = new Mutter(id, name, text);
				
				mutterList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("うまく検索できなかったよ");
			return null;
		}
		return mutterList;
	}

	/*---------------------------------------*/
	//		追加処理一覧
	//			create
	/*---------------------------------------*/
	//つぶやきを１件追加するメソッド
	public boolean create(Mutter mutter) {
		try(
				Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		) {
			//ひな形生成、ID不要、なぜなら、自動で連番がつけられるSERIAL型を使っているため
			String sql = "INSERT INTO mutter(name, text) VALUES(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//ひな形へ値を流し込む
			pstmt.setString(1, mutter.getUserName());
			pstmt.setString(2, mutter.getText());
			
			//SQL送信
			int r = pstmt.executeUpdate(); //更新系の場合はint型が帰ってくる

			//結果を判定する
			//正常に追加出来たら r の値は1であるはずだ
			if(r != 1) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("追加出来なかったよ、なんか問題あるかも");
			return false;
		}
		
		//ここに到達したら正常に処理が実行された
		return true;
	}
}
