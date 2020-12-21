package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cnt = 0;	//방문 횟수를 저장하기 위한 변수이다. 
		Cookie[] list = req.getCookies();	//쿠키를 모두 읽어 list에 저장
		for(int i = 0; list != null && i < list.length; i++) {	
			if(list[i].getName().equals("count")){		//쿠키의 이름이 count인 쿠키를 찾는다.
				cnt = Integer.parseInt(list[i].getValue());	
			}
		}
		cnt++;		//현재 방문 횟수에 대한 정보를 계속 유지해야 다음 방문때 방문횟수를 계산할 수 있다.
					// 유ㅗ지하기 위해 쿠키를 생성하여 클라이언트 쪽에 저장한다. 이전에 방문한 횟수를
					//쿠키에서 찾을 때 쿠키 이름을 count로 했기 때문에 count이름으로 현재 방문 횟수에
					//대한 정보가 들어있는 cnt변수값을 저장한다. 
		Cookie c = new Cookie("count" , cnt+"");
		c.setMaxAge(60*60*24*10);
		resp.addCookie(c);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1>방문 횟수 : " + cnt);
		out.close();
		
	}
	
}
