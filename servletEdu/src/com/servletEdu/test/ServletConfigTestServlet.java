package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String env = this.getInitParameter("charset");
		req.setCharacterEncoding(env);
		out.print("<h3> ¿Ã∏ß : " + req.getParameter("name"));
		out.close();
	}
}
