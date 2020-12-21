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
		out.println("<body><h2>ó�� ���(���� ����)</h2>");
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
		 * ����
		 * http://localhost:8080/servletEdu/local?msg=one
		 * http://localhost:8080/servletEdu/local?msg=two
		 * �� �Է��Ͽ� ������ Ư¡�� �˾ƺ���.
		 * ���������� �����߰�, �� �������� ���ÿ����� ������ str ������ Ŭ���̾�Ʈ���� �������
		 * ���ǹǷ� �� Ŭ���̾�Ʈ�� str�������� �����ص� �ٸ� Ŭ���̾�Ʈ���� ������ ��ġ�� �ʴ´�.
		 */
	}
}