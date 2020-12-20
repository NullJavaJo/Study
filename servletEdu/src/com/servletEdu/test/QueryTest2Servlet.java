package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest2")
public class QueryTest2Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>���ڿ� �׽�Ʈ</title></head>");
		out.print("<body>");
		out.print("<h1>POST��� ���� ���ڿ� ����</h1>");

		ServletInputStream input = req.getInputStream(); // req.getInputStream()�� ��û������ body�� ���� ���α׷����� ����� �Է½�Ʈ���� �����Ͽ�
															// ��ȯ���ִ� �޼ҵ��̴�. getInputStream�޼ҵ忡�� ��ȯ�� input�� ��û������ body��
															// �������� ����� ServletInputStream��ü�̴�. ServletInputStream��ü��
															// �Է½�Ʈ�����μ�, ��û���� .body�� �ִ� �����͸� �������α׷����� �о���� ���� ����Ѵ�.
		int len = req.getContentLength(); // req.getContentLength()�� ��û������ .body�� ����ִ� ���ڿ��� ���̸� ��ȯ�Ѵ�.
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len); // input �Է½�Ʈ������ ���� �ٴ����� �����͸� �д� �޼ҵ��̴�. ������ ù��°�� buf�� ������ ����Ʈ�迭�� �����ϴ°��̰�, �ι�°��
										// ������ ���� ��ġ, ����°�� ������ ���ڿ��� �����̴�.
		String s = new String(buf);		//buf ����Ʈ �迭�� StringŸ������ ���� �����ϴ� �����̴�. 
		out.print("��ü ���ڿ� : " + s);

		out.println("</body></html>");
		out.close();
	}
}
