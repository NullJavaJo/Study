package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerInfo")
public class HeaderInfoSerlvet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		// HTTP ���������� ��û������ ���(header)�� ��ü(body)�� �����Ǿ� �ְ�, ����� �ι��� �� ���ĺ��ʹ� "name:value"���·� ����� �������� ����ִ�. 
		res.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request ���� ��� Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>��û ��� ����</h3>");
		Enumeration<String> em = req.getHeaderNames();					/*req.getHeaderNames()�� ��û������ ��� �ȿ� �ִ� ������ ��� �̸��鸸 ��� Enumeration��ü�� ��� ��ȯ�ϰ�, 
																		��ȯ�� ���� �����ּҸ� em ������ �����Ѵ�. Enumeration����ü�� java.util ��Ű���� �����ְ�, �迭ó�� ������ �׷����� ������
																		Collection��ü�̴�. 
																		Enumeration��ü�� Set, List, Map Collection ��ü�� �ٸ����� �׷��� �����Ϳ� ������ �� �ε����� Ű�� �ƴ�
																		Ŀ����� �������� �����Ѵٴ� ����̴�. req.getHeaderNames()�� ��� ������ �̸����� String Ÿ������ Enumeration��ü��
																		��� ��ȯ�ϸ� Enumeration��ü�� ù��° ��� �տ� Ŀ���� ��ġ�Ѵ�. 
																		�� �ܿ� Ŀ���� �������� �����ϴ� collection��ü���� Iterator�� ������ �ַ� ��� ��ҵ��� ���ʷ� ������ �� ����ϸ� ���ϰ�, �ӵ��� ������.*/
		while(em.hasMoreElements()) {									// em.hasMoreElements()�� em�� ����Ű�� Enumeration��ü�� Ŀ�� ������ �����Ͱ� �ִ��� ������ �Ǵ��ؼ� boolean����
			String s = em.nextElement();								// em.nextElement()�� em�� Ŀ�� ������ �ִ� ��Ҹ� ��ȯ�ϰ� ���� ��ҷ� Ŀ���� �̵���Ų��. 
			out.println(s + " : " + req.getHeader(s) + "<br/>");		// s���� ��û������ ��� �̸��� ����ִµ�, ����̸��� getHeader()�� ���ڷ� �����ϸ� �ش� �̸��� ã�� ��ȯ�Ѵ�. ��, getHeader()�� ����� ���� �����ϴ� �޼ҵ��̴�. 
		}
		out.print("</body></html>");
		out.close();
		
		
	}
}
