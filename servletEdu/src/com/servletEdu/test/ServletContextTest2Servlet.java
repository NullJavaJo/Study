package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context2")
public class ServletContextTest2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext sc = this.getServletContext();
		
		out.print("���� ���� : " + sc.getMajorVersion() + "." + sc.getMinorVersion());
		out.print("<br>���� ���� : " + sc.getServerInfo());
		out.print("<br>�� ���ø����̼� ��� : " + sc.getContextPath());
		out.print("<br>�� ���ø����̼� �̸� : " + sc.getServletContextName());
		out.print("<br>���� ���� ��� : " + sc.getRealPath("/name.html"));
		sc.log("�α� ���!!");
		
		out.close();
	}
	
}
