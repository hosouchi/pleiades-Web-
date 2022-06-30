//つぶやきの投稿に関する処理を行うモデル

package model;

import dao.MutterDAO;

public class PostMutterLogic {

	//MutterDAOを使用して、MutterインスタンスをMutterテーブルに追加
	
	public void execute(Mutter mutter) {
		
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
}
