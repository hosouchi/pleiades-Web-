//LoginLogicをテストするクラス

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Login;
import model.LoginLogic;

class TestLoginLogic {

	//ドライバメソッドにはstaticつけるとグリーン/レッドバーが表示されなくなるみたい
	
	//パスワードがあっていることを確認
	@Test
	public void testExecute1() {
		Login login = new Login("minato" , "1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		assertEquals(result,true);
	}
	
	//パスワード違いではじかれることを確認
	@Test
	public void testExecute2() {
		Login login = new Login("minato" , "12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		assertTrue(result == false);
	}
}
