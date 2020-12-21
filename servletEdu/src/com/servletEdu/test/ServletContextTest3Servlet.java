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
		obj1.setStr("객체 공유 테스트 - 1");
		sc.setAttribute("data1", obj1);
		
		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트 - 2");
		sc.setAttribute("data2", obj2);
		
		out.print("ServletContext객체에 데이터 등록을 하였습니다.");
		
		out.close();
	}
	
}
