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
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>요청방식과 프로토콜 정보</h3>");
		out.print("Request URI : " + req.getRequestURI() + "<br/>");		/*client가 요청한 문서정보를 반환한다. 클라이언트가 서비스를 요청했을 때 HTTP 프로토콜에 의해 요청정보가 웹서버에 전달된다. 
																			요청정보 헤더의 첫번째 줄에는 요청방식, URI, HTTP 버전정보 이렇게 3개가 들어가는데, 
																			이 메소드는 2번쨰 정보인 URI를 추출하는 메소드이다. */
		out.print("Request URL : " + req.getRequestURL() + "<br/>");		// client가 서비스를 요청한 문서의 전체정보 즉 URL을 반환하는 메소드이다. 
		out.print("Context Path : " + req.getContextPath() + "<br/>");		// 웹애플리케이션의 경로 정보를 반환한다. 
		out.print("Request Protocol : " + req.getProtocol() + "<br/>");		// 서비스를 처리하면서 사용되는 프로토콜의 구체적인 정보를 반환한다. 
		out.print("Servlet Path : " + req.getServletPath() + "<br/>");		// 웹 애플리케이션을 루트 디렉터리 기준으로 서블릿의 경로를 반환한다. 
		out.print("</body></html>");
		out.close();
		
	}
}
