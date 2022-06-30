//つぶやきの取得に関する処理を行うモデル

package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {
	
	//Mutterテーブルの全レコードを取得し、それをreturn
	public List<Mutter>execute(){
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAllList();
		return mutterList;
	}
}
