package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/netInfo")
public class NetInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		res.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request ���� ��� Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>��Ʈ��ũ ���� ��û ����</h3>");
		out.print("Request Scheme : " + req.getScheme() + "<br/>");		// client�� �������� ���񽺸� ��û�� �� ����� �������� �̸��� ��ȯ�ϴ� �޼ҵ��̴�.
		out.print("Server Name : " + req.getServerName() + "<br/>");	// ������ ȣ��Ʈ �̸��� ��ȯ�ϴ� �޼ҵ��̴�. ������ �̸��� ���� ��� IP�ּҸ� ��ȯ�Ѵ�.
		out.print("Server Address : " + req.getLocalAddr() + "<br/>");	// client�� ���� ���񽺸� ��û���� ������ IP�ּҸ� ��ȯ�Ѵ�.
		out.print("Server Port : " + req.getServerPort() + "<br/>");	// Client�� ���񽺸� ��û�޾� ó���ϴ� ������ ��Ʈ ��ȣ�� ��ȯ�Ѵ�.
		out.print("Client Address : " + req.getRemoteAddr() + "<br/>");	// ���񽺸� ��û�� client�� IP�ּҸ� ��ȯ�Ѵ�.
		out.print("Cleint Host : " + req.getRemoteHost() + "<br/>");	// ���񽺸� ��û�� client�� ȣ��Ʈ �̸��� ��ȯ�Ѵ�. ȣ��Ʈ�� �̸��� ���ٸ� IP�ּҸ� ��ȯ�Ѵ�.
		out.print("Client Port : " + req.getRemotePort() + "<br/>");	// ���񽺸� ��û�� Ŭ���̾�Ʈ�� �ҽ� ��Ʈ ��ȣ�� ��ȯ�Ѵ�. 
		out.print("</body></html>");
		out.close();
		
		
	}
}
