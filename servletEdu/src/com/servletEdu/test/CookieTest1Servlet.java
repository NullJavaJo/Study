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
		//��Ű�� �̸��� id�̰� ���� guest�� ��Ű c1�� ������ ���� c1.setpate���� ��θ� / �� �����ߴ�
		//���� ���� �� ���ø����̼ǿ� �ִ� ��� ��û�� ���Ͽ� Ŭ���̾�Ʈ���� ��Ű�� ���۵ǵ����ߴ�.
		// resp������ addCoolie()�޼ҵ带 �̿��Ͽ� c1��Ű�� Ŭ���̾�Ʈ ������ �����ߴ�. �׷���
		// c1 ��Ű�� addCoolie()�޼ҵ�� �����ϱ� ���� ��ȿ�ð��� �������� �ʾҴ�. 
		//��ȿ�ð��� �������� ������ -1�� �����ȴ�. ���� �������̹Ƿ� �������� �����ֱ�Ͱ�������.
		
		Cookie c2 = new Cookie("code", "0001");
		c2.setMaxAge(60 * 60 * 3);
		c2.setPath("/");
		resp.addCookie(c2);
		//c2�� ��ȿ�ð��� �ʴ����� �����ؾ��ؼ� �������� �����Ͽ���.
		// 1�ð��� 60��, 1���� 60�ʷ� 3�ð� �����Ͽ���.
		
		Cookie c3 = new Cookie("subject", "java");
		c3.setMaxAge(60 * 60 * 24 * 10);
		// ��ȿ�Ⱓ�� 10�Ϸ� �����ߴ�. 
		c3.setPath("/");
		resp.addCookie(c3);
		
		out.println("��Ű ���� �Ϸ�");
		out.close();
	}
	
}
