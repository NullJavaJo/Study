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
		id = config.getInitParameter("id");		//getInitParameter는 ServletConfig가 갖고 있는 메소드로 web.xml 파일의 <servlet>속성 중 <init-param>으로 지정한 변수의 값을 추출할 때 사용한다. 
		password = config.getInitParameter("password");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print("<h2>서블릿 초기 추출 변수</h2>");
		out.print("<h3>ID : " + id + "</h3>");
		out.print("<h3>PASSWORD : " + password + "</h3>");
		out.close();
	}
	
}
