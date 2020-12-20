package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlInfo")
public class URLInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		res.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request ���� ��� Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>��û��İ� �������� ����</h3>");
		out.print("Request URI : " + req.getRequestURI() + "<br/>");		/*client�� ��û�� ���������� ��ȯ�Ѵ�. Ŭ���̾�Ʈ�� ���񽺸� ��û���� �� HTTP �������ݿ� ���� ��û������ �������� ���޵ȴ�. 
																			��û���� ����� ù��° �ٿ��� ��û���, URI, HTTP �������� �̷��� 3���� ���µ�, 
																			�� �޼ҵ�� 2���� ������ URI�� �����ϴ� �޼ҵ��̴�. */
		out.print("Request URL : " + req.getRequestURL() + "<br/>");		// client�� ���񽺸� ��û�� ������ ��ü���� �� URL�� ��ȯ�ϴ� �޼ҵ��̴�. 
		out.print("Context Path : " + req.getContextPath() + "<br/>");		// �����ø����̼��� ��� ������ ��ȯ�Ѵ�. 
		out.print("Request Protocol : " + req.getProtocol() + "<br/>");		// ���񽺸� ó���ϸ鼭 ���Ǵ� ���������� ��ü���� ������ ��ȯ�Ѵ�. 
		out.print("Servlet Path : " + req.getServletPath() + "<br/>");		// �� ���ø����̼��� ��Ʈ ���͸� �������� ������ ��θ� ��ȯ�Ѵ�. 
		out.print("</body></html>");
		out.close();
		
	}
}
