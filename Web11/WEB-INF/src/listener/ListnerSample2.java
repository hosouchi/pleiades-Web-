package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListnerSample2 implements ServletContextListener {

	//Webアプリ起動時
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//アプリケーションスコープを取得する(ServletContext)
																//Listenerの時はsce.・・・
		ServletContext application = sce.getServletContext();	//Servletの時はthis.・・・
		
		//訪問回数インスタンスを生成して、アプリケーションスコープへ保存する
		Integer cnt = 0;
		application.setAttribute("cnt", cnt);
		
		System.out.println("contextInitialized()実行");

	}
	//Web終了時
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
