package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html;charset=UTF-8");	//이 태그가 없는 경우 데이터타입과 문자셋의 정보를 명시하지 않았기 때문에 기본값인 text/html문서타입과 8859_1의 문자셋으로 처리하는데 8859_1은 한글을 지원하지 않기 때문에 깨져나온다. 
		PrintWriter out = resp.getWriter();
		out.print("<h1>좋은 하루!</h1>");
		out.close();
	}
}
