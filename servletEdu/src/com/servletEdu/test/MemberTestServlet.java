package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberTestServlet extends HttpServlet {

	String str;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int number = 0;
		str = req.getParameter("msg");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>MultiThread Test</title></head>");
		out.println("<body><h2>처리 결과(지역 변수)</h2>");
		while (number++ < 10) {
			out.print(str + " : " + number + "<br>");
			out.flush();
			System.out.println(str + " : " + number);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		out.println("<h2>Done " + str + " !!</h2>");
		out.println("</body></html>");
		out.close();
	}
	/*
	 * 각각 
	 * http://localhost:8080/servletEdu/member?msg=one
	 * http://localhost:8080/servletEdu/member?msg=two
	 * 로 실행하여 보자.
	 * str변수가 멤버변수로 선언되었기 때문에 객체 생성시 힙 영역에 만들어진 후 모든 클라이언트가 공유한다.
	 */

}
