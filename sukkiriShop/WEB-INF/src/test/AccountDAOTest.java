//AccountDAOをテストするクラス

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {

	//アカウントが見つかるはずのテスト
	@Test
	public void testFindByLogin() {
		
		//ログインしようとしているユーザーを生成
		Login login = new Login("minato" , "1234");
		
		//アカウントをデータベースから検索する
		Account account = AccountDAO.findByLogin(login);
				//↑うまく取得できていないため、nullが返ってきている
		
		//取得したアカウントのuser_idは「minato    」であるはずだ
		assertEquals("minato    ", account.getUserId());
		
		//取得したアカウントのpassは1234であるはずだ
		assertEquals("1234", account.getPass());
		
		//取得したアカウントのmailはmianto@sukkiri.com
		assertEquals("minato@sukkiri.com", account.getMail());
		
		//取得したアカウントのnameは湊　雄輔であるはずだ
		assertEquals("湊　雄輔", account.getName());
		
		//取得したアカウントのageは23であるはずだ
		assertEquals(23, account.getAge());
		
	}
	
	//アカウントが見つからないはずのテスト
	@Test
	public void testFindByLogic2() {
		
		//ログインしようとしているユーザーを生成
		Login login = new Login("minato" , "12345");
		
		//アカウントをデータベースから検索
		Account account = AccountDAO.findByLogin(login);
		
		//アカウントはnullであるはずだ
		assertEquals(null, account);
		
	}
}
