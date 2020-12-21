package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3> Dispatcher Test1�� ������<h3>");
		
		ServletContext sc = this.getServletContext();		
		//ServletContext��ü�� �����ϴ� ������ ServletContext���� �����ϴ� 
		//RequestDispatcher�� �����ϱ� ���� �޼ҵ带 ����ϱ� ���ؼ��̴�. 
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");
		//ServletContext�� getRequestDispatcher�� ����� RequestDispatcher��ü��
		//������ �� ��ȯ�޴´�. ��ȯ�� rd�� "/dispatcher2"��� path���� ������.
		//rd.forward(req, resp);
		rd.include(req, resp);
		out.close();	//close�� �Ǹ鼭 �ڵ����� flush���ִµ� forward�� �̵��ع����� ������
		//close�޼ҵ带 �������� ���ϰ� ����������, include�� �ٽ� ���ƿ� �����ϱ� ������ 2�� �� ���
	}
}
