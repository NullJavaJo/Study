package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie1")
public class CookieTest1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie c1 = new Cookie("id", "guest");
		c1.setPath("/");
		resp.addCookie(c1);
		//쿠키의 이름은 id이고 값은 guest인 쿠키 c1을 생성한 다음 c1.setpate에서 경로를 / 로 지정했다
		//따라서 현재 웹 애플리케이션에 있는 모든 요청에 대하여 클라이언트쪽의 쿠키가 전송되도록했다.
		// resp변수의 addCoolie()메소드를 이용하여 c1쿠키를 클라이언트 쪽으로 전송했다. 그런데
		// c1 쿠키는 addCoolie()메소드로 전송하기 전에 유효시간을 지정하지 않았다. 
		//유효시간을 지정하지 않으면 -1로 지정된다. 따라서 음수값이므로 브라우저의 생명주기와같아진다.
		
		Cookie c2 = new Cookie("code", "0001");
		c2.setMaxAge(60 * 60 * 3);
		c2.setPath("/");
		resp.addCookie(c2);
		//c2는 유효시간을 초단위로 지정해야해서 수식으로 지정하였다.
		// 1시간은 60분, 1분은 60초로 3시간 설정하였다.
		
		Cookie c3 = new Cookie("subject", "java");
		c3.setMaxAge(60 * 60 * 24 * 10);
		// 유효기간을 10일로 설정했다. 
		c3.setPath("/");
		resp.addCookie(c3);
		
		out.println("쿠키 전송 완료");
		out.close();
	}
	
}
