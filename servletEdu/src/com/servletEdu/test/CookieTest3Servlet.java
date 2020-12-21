package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cnt = 0;	//�湮 Ƚ���� �����ϱ� ���� �����̴�. 
		Cookie[] list = req.getCookies();	//��Ű�� ��� �о� list�� ����
		for(int i = 0; list != null && i < list.length; i++) {	
			if(list[i].getName().equals("count")){		//��Ű�� �̸��� count�� ��Ű�� ã�´�.
				cnt = Integer.parseInt(list[i].getValue());	
			}
		}
		cnt++;		//���� �湮 Ƚ���� ���� ������ ��� �����ؾ� ���� �湮�� �湮Ƚ���� ����� �� �ִ�.
					// �������ϱ� ���� ��Ű�� �����Ͽ� Ŭ���̾�Ʈ �ʿ� �����Ѵ�. ������ �湮�� Ƚ����
					//��Ű���� ã�� �� ��Ű �̸��� count�� �߱� ������ count�̸����� ���� �湮 Ƚ����
					//���� ������ ����ִ� cnt�������� �����Ѵ�. 
		Cookie c = new Cookie("count" , cnt+"");
		c.setMaxAge(60*60*24*10);
		resp.addCookie(c);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1>�湮 Ƚ�� : " + cnt);
		out.close();
		
	}
	
}
