package com.servletEdu.test;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet {

//	ù��° �׽�Ʈ
//	ServletContext sc;		// ServletContext�� �ּҰ��� ���� sc ���������� �����Ѵ�. 
//	@Override
//	public void init(ServletConfig config)throws ServletException{
//		sc = config.getServletContext();	//getServletContext�� ����Ͽ� ServletContext �ּҰ��� ������ �� sc�� �����Ѵ�. 
//	}
	
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		out.print("Context : " + sc);
//		out.close();
//	}
	
//	�ι�° �׽�Ʈ
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		ServletContext sc = this.getServletContext();
//		out.print("Context : " + sc);
//		out.close();
//	}

//	����° �׽�Ʈ
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		ServletContext sc = this.getServletContext();
		String location = sc.getInitParameter("contextConfig");
		//���� �� ���ø����̼��� web.xml���� <context-param>�±׸� ã�� contextConfig�� �̸���
		//������ �ִ� <param-name>�� <param-value>���� ��ȯ�Ѵ�.
		out.print("location : " + location);
		out.close();
	}
	
	
}
