package model;

import java.util.List;

import dao.MutterDAO;

public class SearchLogic {
	//検索したい文字列をわたして、検索結果が帰ってくる
	//メソッド名:execute
	//引数：検索したい文字列
	//戻り値：つぶやきリスト一覧
	public List<Mutter> execute(String searchText) {
		MutterDAO dao = new MutterDAO();
		return dao.findContainText(searchText);
	}
}
