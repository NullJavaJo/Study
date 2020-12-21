package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context3")
public class ServletContextTest3Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext sc = this.getServletContext();
		
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("��ü ���� �׽�Ʈ - 1");
		sc.setAttribute("data1", obj1);
		
		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("��ü ���� �׽�Ʈ - 2");
		sc.setAttribute("data2", obj2);
		
		out.print("ServletContext��ü�� ������ ����� �Ͽ����ϴ�.");
		
		out.close();
	}
	
}
