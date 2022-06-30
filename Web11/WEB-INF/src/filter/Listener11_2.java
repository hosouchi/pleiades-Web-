package filter;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class Listener11_2 implements ServletContextAttributeListener {

	//スコープへデータが追加（保存）されたら
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("アプリケーションスコープの利用は禁止しています");
	}

	//スコープ内のデータがなくなったら
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {}

	//スコープ内のデータに変更があったら
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {}

}
