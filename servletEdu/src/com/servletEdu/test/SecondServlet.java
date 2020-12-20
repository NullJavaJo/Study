package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("SecondServlet!!");
	} //������ SecondServlet!!
	/*
	 *		/second.�� ��û�ϸ� SecondServlet�� init()�޼ҵ尡 ����Ǿ�� �ϴµ�, ���������� �ʾƼ� GenericServlet Ŭ������ init()�޼ҵ尡 ����ȴ�. 
	 *		�׸��� service()�޼ҵ嵵 ������ ���� �ʾƼ� GenericServletŬ������ ��ӹ޾� ������ HttpServletŬ������  service(ServletRequest, ServletResponse)�޼ҵ尡 ����ǰ� 
	 *		�� �޼ҵ�� HttpSerlvetŬ������ service(HttpServletRequest, HttpServletResponse)�޼ҵ带ȣ���Ѵ�. �׸��� �� �޼ҵ�� �ٽ� SecondServletŬ������ doGet()�޼ҵ带 ȣ���Ͽ� �����Ѵ�. 
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("SecondServlet!!");
		PrintWriter out = resp.getWriter();		//resp�� ���� ������� ó����°��� �� �� �ְ�, �����͸� ����ϱ� ���� ��½�Ʈ���� �����ϴ� �޼ҵ��̴�. �̸� ���� out�� ���� client���� �����͸� ����� �� �ִ�
		out.print("<html><head><title>Test</title></head>");	//������ ���ڿ��� ������ �������� �ȿ� � Ÿ���� ������ �����ٰ� �����ϴ� �κ��� ����. �׷���� �⺻���� text/html�� ó���Ѵ�. �� ��� HTML�±׷� �ν��Ͽ� ó���Ѵٰ� ���� �ȴ�.
		out.print("<body><h1>have a nice day!!</h1></body>");
		out.print("</html>");
		out.close();	//out�̶�� �̸��� ��Ʈ���� �ݾ��ִ� �޼ҵ��̴�. �� resp.getWriter()�� �̿��Ͽ� ���������� ���������� ����� ��½�Ʈ���� �����ִ� ��ɹ��̴�.  
	}
	
}
