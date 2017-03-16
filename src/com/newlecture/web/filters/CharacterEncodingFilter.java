package com.newlecture.web.filters;
//필터
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") //실행이 잘못되면 톰캣이 안될수도 있땅 콘피규어? 무조건 /가있어야함 어떠한 요청이 있어도 얘를 통해서 실행이 된다.?
public class CharacterEncodingFilter implements Filter {


	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
