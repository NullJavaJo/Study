package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String param = req.getParameter("p");
		String msg = null;		// ó���� ���� ���� �������� ����� ���ڿ��� ������ �����̴�.
		HttpSession session = null;	//HttpSession�� �ּҰ��� ���� �����̴�.
		
		if(param.equals("create")) {
			session = req.getSession();
			if(session.isNew()) {
				msg = "���ο� ���� ��ü�� ������";
			}else {
				msg = "������ ���� ��ü�� ���ϵ�";
			}	//param ������ create���ڿ��� ���� �� ����Ǵ� �κе�. req.getSession���� ����
				//��ü�� ������ session������ �����ϰ� ���� ������ �������� ������ ���� ������ ��ȯ�Ѵ�.
				//session.isNew()�� req.getSession()���� ��ȯ���� ���ǰ�ü�� ���� �����Ǿ�
				//��ȯ�� ���ǰ�ü���� ������ü���� �Ǵ��Ѵ�. 
		}else if(param.equals("delete")) {
			session = req.getSession(false);
			if(session != null) {
				session.invalidate();
				msg="���� ��ü ���� �۾� �Ϸ�";
			}else {
				msg = "������ ���� �������� ����";
			}// ���ڸ�false�� ���������Ƿ� ���ǰ�ü�� �������� ������ null�� ��ȯ�޴´�.if������
			//session�� null�� �ƴ϶�� session.invalidate()�� ���� ��ü�� �����Ѵ�. 
		}else if(param.equals("add")) {
			session = req.getSession(true);
			session.setAttribute("msg", "�޼����Դϴ�");
			msg = "���� ��ü�� ������ ��� �Ϸ�";
			//req.getSession�� true���ڷ� �����Ͽ� ���ǰ�ü�� �������� ������ ���� �����Ͽ� ��ȯ�޴´�.
		}else if(param.equals("get")) {
			session = req.getSession(false);
			if(session != null) {
				String str = (String)session.getAttribute("msg");
				msg = str;
			}else {
				msg = "�����͸� ������ ���� ��ü �������� ����";
			}
		}else if(param.equals("remove")) {
			session = req.getSession(false);
			if(session != null) {
				session.removeAttribute("msg");
				msg = "���� ��ü�� ������ ���� �Ϸ�";
			}else {
				msg = "�����͸� ������ ���� ��ü �������� ����";
			}
		}else if(param.equals("replace")) {
			session = req.getSession();
			session.setAttribute("msg", "���ο� �޼����Դϴ�.");
			msg = "���� ��ü�� ������ ��� �Ϸ�";
		}
		
		out.print("ó����� : " + msg);
		out.close();
		
	}
	
}
