package model;

public class RegisterUserLogic {

	public boolean execute(User user) {
		
		//登録処理(データベースへ登録など)
		System.out.println(String.format("[id : %s / name : %s]を登録", user.getId(),user.getPass(),user.getName()));
		return true;
	}
	
}
