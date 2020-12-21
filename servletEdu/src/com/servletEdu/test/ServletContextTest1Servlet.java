package com.servletEdu.test;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet {

//	첫번째 테스트
//	ServletContext sc;		// ServletContext의 주소값을 갖는 sc 참조변수를 선언한다. 
//	@Override
//	public void init(ServletConfig config)throws ServletException{
//		sc = config.getServletContext();	//getServletContext를 사용하여 ServletContext 주소값을 추출한 후 sc에 저장한다. 
//	}
	
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		out.print("Context : " + sc);
//		out.close();
//	}
	
//	두번째 테스트
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		ServletContext sc = this.getServletContext();
//		out.print("Context : " + sc);
//		out.close();
//	}

//	세번째 테스트
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		ServletContext sc = this.getServletContext();
		String location = sc.getInitParameter("contextConfig");
		//현재 웹 애플리케이션의 web.xml에서 <context-param>태그를 찾아 contextConfig란 이름을
		//가지고 있는 <param-name>의 <param-value>값을 반환한다.
		out.print("location : " + location);
		out.close();
	}
	
	
}
