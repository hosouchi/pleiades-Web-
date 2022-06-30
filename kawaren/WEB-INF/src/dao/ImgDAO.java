package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ImgBean;

public class ImgDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバの読み込みに失敗しています");
			e.printStackTrace();
		}
	}
	
	//ファイル名で行を特定し、その画像データを返却するメソッドを作成
	public static byte[] selectImg(String filename) {
		
		try(
			Connection con = DriverManager.getConnection("jdbc:postgresql:imgdb","postgres","postgres");
			PreparedStatement ps = con.prepareStatement("select imgdata from t_img where filename = ?",
														ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			
		){
			ps.setString(1, filename);
			
			//このResultSetインスタンスには1行か0行のどちらか・・・最初のレコードにピンポイントでカーソルを当てられたらいいな
			ResultSet rs = ps.executeQuery();
			
			//rs.first()で最初のレコードにピンポイントでカーソルを当てている。rs.first() == true という意味
			if(rs.first()) {
				byte[] imgdata = rs.getBytes("imgdata");
				return imgdata;
			}else {
				//そのファイル名の画像データはなかったので
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//全行取得（ResultSet）→ArrayList<ImgBean>変換処理
	public static ArrayList<ImgBean> selectAll(){
		
		try(
			//Connectionに詰め込める
			Connection con = DriverManager.getConnection("jdbc:postgresql:imgdb","postgres","postgres");
			PreparedStatement ps = con.prepareStatement("select filename , cont , comment from t_img");
			ResultSet rs = ps.executeQuery();
		){
			
			//ArrayList<ImgBean>をインスタンス化する
			ArrayList<ImgBean> list = new ArrayList<>();
			
			while(rs.next()) {
				String filename = rs.getString("filename");
				String cont = rs.getString("cont");
				String comment = rs.getString("comment");
				
				//ファイル名、投稿者、コメントの３つでImgbeanをインスタンス化できるようにコンストラクタ作成しておいた
				ImgBean bean = new ImgBean(filename, cont, comment);
				
				list.add(bean);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean insertImg(ImgBean ibean) {
		
		try(
				Connection con = DriverManager.getConnection("jdbc:postgresql:imgdb","postgres","postgres");
				PreparedStatement ps = con.prepareStatement("insert into t_img values(?,?,?,?)");
		){
			// ?(プレースホルダ)にJavaBeansの中のデータを順にセット
			ps.setString(1, ibean.getFilename());	// 1個目の?にファイル名（文字列）
			ps.setString(2, ibean.getCont());		// 2個目の?に投稿者名（文字列）
			ps.setString(3, ibean.getComment());	// 3個目の?に	コメント（文字列）
			ps.setBytes(4, ibean.getImgdata());		// 4個目の?に画像の生データ（byte[]）
			
			int rec = ps.executeUpdate();
			if(rec == 1) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;	//例外が発生した場合も、行の登録は失敗しているはずなのでfalseを返す
		}
		
	}
}
