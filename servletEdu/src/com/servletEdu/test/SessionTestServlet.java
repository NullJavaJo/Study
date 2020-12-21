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
		String msg = null;		// 처리가 끝난 다음 브라우저에 출력할 문자열을 가지는 변수이다.
		HttpSession session = null;	//HttpSession의 주소값을 가질 변수이다.
		
		if(param.equals("create")) {
			session = req.getSession();
			if(session.isNew()) {
				msg = "새로운 세션 객체가 생성됨";
			}else {
				msg = "기존의 세션 객체가 리턴됨";
			}	//param 변수에 create문자열이 있을 때 실행되는 부분디ㅏ. req.getSession으로 세션
				//객체를 추출해 session변수에 저장하고 만일 세션이 존재하지 않으면 새로 생성해 반환한다.
				//session.isNew()는 req.getSession()에서 반환받은 세션객체가 새로 생성되어
				//반환된 세션객체인지 기존객체인지 판단한다. 
		}else if(param.equals("delete")) {
			session = req.getSession(false);
			if(session != null) {
				session.invalidate();
				msg="세션 객체 삭제 작업 완료";
			}else {
				msg = "삭제할 세션 존재하지 않음";
			}// 인자를false로 지정했으므로 세션객체가 존재하지 않으면 null을 반환받는다.if문으로
			//session이 null이 아니라면 session.invalidate()로 세션 객체를 삭제한다. 
		}else if(param.equals("add")) {
			session = req.getSession(true);
			session.setAttribute("msg", "메세지입니다");
			msg = "세션 객체에 데이터 등록 완료";
			//req.getSession을 true인자로 지정하여 세션객체가 존재하지 않으면 새로 생성하여 반환받는다.
		}else if(param.equals("get")) {
			session = req.getSession(false);
			if(session != null) {
				String str = (String)session.getAttribute("msg");
				msg = str;
			}else {
				msg = "데이터를 추출할 세션 객체 존재하지 않음";
			}
		}else if(param.equals("remove")) {
			session = req.getSession(false);
			if(session != null) {
				session.removeAttribute("msg");
				msg = "세션 객체의 데이터 삭제 완료";
			}else {
				msg = "데이터를 삭제할 세션 객체 존재하지 않음";
			}
		}else if(param.equals("replace")) {
			session = req.getSession();
			session.setAttribute("msg", "새로운 메세지입니다.");
			msg = "세션 객체에 데이터 등록 완료";
		}
		
		out.print("처리결과 : " + msg);
		out.close();
		
	}
	
}
