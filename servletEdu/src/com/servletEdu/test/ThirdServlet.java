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
		
		resp.setContentType("text/html;charset=UTF-8");	//�� �±װ� ���� ��� ������Ÿ�԰� ���ڼ��� ������ ������� �ʾұ� ������ �⺻���� text/html����Ÿ�԰� 8859_1�� ���ڼ����� ó���ϴµ� 8859_1�� �ѱ��� �������� �ʱ� ������ �������´�. 
		PrintWriter out = resp.getWriter();
		out.print("<h1>���� �Ϸ�!</h1>");
		out.close();
	}
}
