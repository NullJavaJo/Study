package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest3")
public class QueryTest3Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8"); // 서버에서 client로 보내는 응답에 관한 기능을 처리해준다.
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h1>GET 방식으로 요청되었습니다.</h1>");

		String name = req.getParameter("name");
		out.print("이름 : " + name + "<br/>");

		out.print("</body></html>");
		out.close();
	}

	/*
	 * GET방식의 인코딩 작업할 떄는 클라이언트가 입력하는 질의 문자열의 인코딩 문자코드는 무엇인지, 서버에서 URI를 인코딩하는 문자코드는
	 * 무엇인지 알아야한다. 
	 * 1. 클라이언트가 입력하는 질의 문자열의 인코딩 문자코드는? 
	 * 클라이언트가 입력하는 질의문자열을 인코딩하는 방법은 2가지이다. 소스에서 직접 인코딩 문자코드 지정하는방법과 이클립스에서 지정하는방법이다. 소스에서는 <meta-charset>태그에 적어주는 방법이다. 
	 * 이클립스에서 하는방법은 window - preferences - web- html files 이다. 만약 한꺼번에 설정할때는 window-preferences-general-contenttypes- text - default encoding에 적어주면됨
	 * 2. 서버에서 URI인코딩하는 문자코드는?
	 * servers - server.xml - connector 태그에 볼수있다 (URIEncoding="UTF-8")
	 * html meta 태그 삭제하면?
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8"); // resp타입/ 서버에서 client로 보내는 응답에 관한 기능을 처리해준다.
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h1>POST 방식으로 요청되었습니다.</h1>");

		req.setCharacterEncoding("UTF-8"); // req타입/ client가 보낸정보를 서버쪽에서 처리할 떄 사용한다. body에 있는 data만 인코딩해주는 메소드라 GET방식에는
											// 사용불가하다.
		String name = req.getParameter("name"); // getParameter() 메소드로 문자열을 추출하기 전 setCharacterEncoding() 메소드가 먼저 실행되었기
												// 떄문에 추출시 인코딩 처리 후의 문자열을 반환한다.
		out.print("이름 : " + name + "<br/>");

		out.print("</body></html>");
		out.close();

	}
	/*
	 * 한글이 왜 깨지지? 회원가입 서비스 처리과정 
	 * 1. 웹 브라우저에서 회원가입 입력 폼에 회원정보 데이터를 입력하고, 입력이 완료되면Submit버튼을 클릭하여 입력한 회원정보데이터를 서버쪽으로 전송한다. 
	 * 2. 서버 프로그램에서 전송된 회원정보를 추출한다. 
	 * 3. 추출한 회원정보를 회원가입서비스를 처리하는 메소드를 호출하면서 인자값으로 전달한다. 
	 * 4. 회원가입 처리 메소드는 DB에 회원정보를 저장하는 작업을 수행하는 메소드를 호출한다. DB처리 메소드 호출시 회원정보를 인자값으로 전달한다. 
	 * 5. DB 처리 메소드는 DB에 회원 테이블에 회원정보를 insert한다. 
	 * 6. DB의 회원 테이블에 회원정보가 저장된다.
	 */

	/*
	 * EUC-KR과 UTF-8의 차이 
	 * EUC-KR은 한글과 영문만지원하는 문자코드로 한글자당 2byte를 사용한다. 다른나라 언어를 지원하지 않는다는 단점이있다. 장점은 2byte로 표현하기 때문에 용량을 적게 차지한다. 
	 * UTF-8은 전세계 언어를 표현할 수 있지만, 영어는 1byte, 한글은 3byte로 표현하기 때문에 EUC-KR보다 용량을 많이 차지한다.
	 */

}
