package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param = req.getParameter("site");
		if(param.equals("naver")){
			resp.sendRedirect("http://www.naver.com");
		}else if (param.equals("daum")) {
			resp.sendRedirect("http://www.daum.net");
		}else if(param.equals("zum")) {
			resp.sendRedirect("http://zum.com");
		}else if(param.equals("google")) {
			resp.sendRedirect("http://www.google.com");
		}
		
	}
	
}
