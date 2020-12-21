package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		int number = 0;
		String str = req.getParameter("msg");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>MultiThread Test</title></head>");
		out.println("<body><h2>처리 결과(지역 변수)</h2>");
		while(number++ < 10) {
			out.print(str + " : " + number + "<br>");
			out.flush();
			System.out.println(str + " : " + number);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		out.println("<h2>Done " + str + " !!</h2>");
		out.println("</body></html>");
		out.close();
		/*
		 * 각각
		 * http://localhost:8080/servletEdu/local?msg=one
		 * http://localhost:8080/servletEdu/local?msg=two
		 * 를 입력하여 변수의 특징을 알아보자.
		 * 지역변수로 선언했고, 각 스레드의 스택영역에 별도의 str 변수가 클라이언트별로 만들어져
		 * 사용되므로 한 클라이언트가 str변수값을 수정해도 다른 클라이언트에게 영향을 미치지 않는다.
		 */
	}
}
