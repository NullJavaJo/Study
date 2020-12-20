package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/addInfo")
public class AdditionalInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		res.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request ���� ��� Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>�߰����� ��û ����</h3>");
		out.print("Request Method : " + req.getMethod() + "<br/>");		/* client�� �������� ��û����� �����Ͽ� ���񽺸� ��û�� �� �ִ�. �̶� ������ ��û����� ��û������ ����� ù��° �ٿ� ù��°�ܾ�� 
																		ǥ�õǾ� ���޵ȴ�. req.getMethod()�� �̺κ��� ������ �����ϴ� �޼ҵ��̴�. ��, Ŭ���̾�Ʈ�� ��û����� �����ϴ� �޼ҵ��̴�. 
																		��û����� default�� GET�̴�. */
		out.print("Path Info : " + req.getPathInfo() + "<br/>");	// uri���� urlpattern ������ ���� ������ ��ȯ�Ѵ�.
		out.print("Path Translated : " + req.getPathTranslated() + "<br/>");	// path info�� ��θ� �������� ��η� ��ȯ�Ͽ� ��ȯ�Ѵ�.
		out.print("Query String : " + req.getQueryString() + "<br/>");	/* req.getQueryString�� ��û URL���� ?�� ã�� ? �ڿ��ִ� ���ڿ���ü�� �����Ͽ� ��ȯ�Ѵ�. ���� ���
																		http://localhost:8080/servletEdu/addInfo?name=null&addr=java �� ��û�Ѵٸ� name=null&addr=java�� ��ȯ��*/
		out.print("Content Length : " + req.getContentLength() + "<br/>");	/* client�� ������ ���񽺸� ��û�ߴٴ� ���� HTTP��û������ ���´ٴ°��̴�. ��û������ header�� body�� �����Ǿ��ִµ�, 
																			req.getContentLength�� ��û���� body�� �ִ� �������� ���̸� �����ϰ� �Ʒ��� req.getContentType�� body�� �ִ�
																			�������� ����Ÿ���� �����Ѵ�. ���⼭ �� �θ޼ҵ��� ��ȯ���� �ָ�����*/			
		out.print("Content Type : " + req.getContentType() + "<br/>");	// ���񽺸� ��û�� client�� ȣ��Ʈ �̸��� ��ȯ�Ѵ�. ȣ��Ʈ�� �̸��� ���ٸ� IP�ּҸ� ��ȯ�Ѵ�.
		out.print("</body></html>");
		out.close();
		
		
	}
}
