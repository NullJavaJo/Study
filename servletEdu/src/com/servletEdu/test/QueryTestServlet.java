package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		resp.setContentType("text/html; charset=EUC-KR");
//		PrintWriter out = resp.getWriter();
//		out.print("<html>");
//		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
//		out.print("<body>");
//		out.print("<h1>GET 방식으로 요청되었습니다.</h1>");
//		out.print("</body></html>");
//		out.close();
//	}
	// 여기서 꿀팁 코드들의 레이아웃을 보기좋게 정렬하고 싶다면 <Ctrl>+<Shift>+<F>를 눌러보세요 (훗)

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h1>GET 방식으로 요청되었습니다.</h1>");

		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobby"); // req.getParameterValues() 는 값이 하나가 아닌 여러개를 가지는 문자열일 경우
															// 사용하는 메소드로, 보통 다중선택하는 checkbox에 자주씀
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String intro = req.getParameter("introduction");

		out.print("ID : " + id + "<br/>");
		out.print("비밀번호 : " + password + "<br/>");
		out.print("이름 : " + name + "<br/>");
		out.print("취미 : ");
		for (int i = 0; i < hobbies.length; i++) {
			out.print(hobbies[i] + " ");
		}
		out.print("<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("종교 : " + religion + "<br/>");
		out.print("소개 : " + intro + "<br/>");
		out.print("전체 질의 문자열 : " + req.getQueryString()); // req.getQueryString()은 GET방식에서 전체 문자열을 추출하는 메소드이다. URL에 ? 뒤의
															// 모든 문자열을 리턴한다.

		out.println("</body></html>");
		out.close();

	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		resp.setContentType("text/html; charset=EUC-KR");
//		PrintWriter out = resp.getWriter();
//		out.print("<html>");
//		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
//		out.print("<body>");
//		out.print("<h1>POST 방식으로 요청되었습니다.</h1>");
//		out.print("</body></html>");
//		out.close();
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h1>GET 방식으로 요청되었습니다.</h1>");

		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobby"); // req.getParameterValues() 는 값이 하나가 아닌 여러개를 가지는 문자열일 경우
															// 사용하는 메소드로, 보통 다중선택하는 checkbox에 자주씀
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String intro = req.getParameter("introduction");

		out.print("ID : " + id + "<br/>");
		out.print("비밀번호 : " + password + "<br/>");
		out.print("이름 : " + name + "<br/>");
		out.print("취미 : ");
		for (int i = 0; i < hobbies.length; i++) {
			out.print(hobbies[i] + " ");
		}
		out.print("<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("종교 : " + religion + "<br/>");
		out.print("소개 : " + intro + "<br/>");

		out.println("</body></html>");
		out.close();
	}
}
