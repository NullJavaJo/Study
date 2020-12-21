package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bookOutput")
public class BookTest2Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Book book = (Book)req.getAttribute("book");
		
		out.print("<h3>å���� : " + book.getTitle() + "</h3>");
		out.print("<h3>å���� : " + book.getAuthor() + "</h3>");
		out.print("<h3>���ǻ� : " + book.getPublisher() + "</h3>");
		
		out.close();
	}
	
}
// Clinet(html) --/bookReg��û--> bookReg --forward--> bookOutput -- HttpServletRequest,Book-->���� to Client
 