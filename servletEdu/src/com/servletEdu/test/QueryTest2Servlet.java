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
		out.print("<head><title>문자열 테스트</title></head>");
		out.print("<body>");
		out.print("<h1>POST방식 질의 문자열 추출</h1>");

		ServletInputStream input = req.getInputStream(); // req.getInputStream()은 요청정보의 body와 서블릿 프로그램간에 연결된 입력스트림을 생성하여
															// 반환해주는 메소드이다. getInputStream메소드에서 반환된 input은 요청정보의 body와
															// 서블릿간에 연결된 ServletInputStream객체이다. ServletInputStream객체는
															// 입력스트림으로서, 요청정보 .body에 있는 데이터를 서블릿프로그램으로 읽어오기 위해 사용한다.
		int len = req.getContentLength(); // req.getContentLength()는 요청정보의 .body에 담겨있는 문자열의 길이를 반환한다.
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len); // input 입력스트림으로 부터 줄단위로 데이터를 읽는 메소드이다. 인자중 첫번째인 buf는 저장할 바이트배열을 지정하는것이고, 두번째는
										// 저장할 시작 위치, 세번째는 저장할 문자열의 길이이다.
		String s = new String(buf);		//buf 바이트 배열의 String타입으로 새로 생성하는 과정이다. 
		out.print("전체 문자열 : " + s);

		out.println("</body></html>");
		out.close();
	}
}
