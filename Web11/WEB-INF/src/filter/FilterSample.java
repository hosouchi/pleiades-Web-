package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//すべてのサーブレットへフィルタをかます
//@WebFilter("/*")

//formSample02のみフィルターかます
@WebFilter("/formSample02")


public class FilterSample implements Filter {
	
	//フィルタがインスタンス化された時
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	//サーブレットへリクエストされた時のフィルタ処理
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//doFilterより前→リクエスト時フィルター
		req.setCharacterEncoding("UTF-8");
		
		//本当に通過したのか、確認するためコンソールアウトする
		System.out.println("フィルター通過");
		
		chain.doFilter(req, res);
		
		//doFilterより後→レスポンス時フィルター
	}
	
	//フィルタインスタンスが破棄された時
	@Override
	public void destroy() {}
}
