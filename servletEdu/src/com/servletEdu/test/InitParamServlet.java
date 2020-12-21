package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

	String id, password;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		id = config.getInitParameter("id");		//getInitParameter�� ServletConfig�� ���� �ִ� �޼ҵ�� web.xml ������ <servlet>�Ӽ� �� <init-param>���� ������ ������ ���� ������ �� ����Ѵ�. 
		password = config.getInitParameter("password");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print("<h2>���� �ʱ� ���� ����</h2>");
		out.print("<h3>ID : " + id + "</h3>");
		out.print("<h3>PASSWORD : " + password + "</h3>");
		out.close();
	}
	
}
