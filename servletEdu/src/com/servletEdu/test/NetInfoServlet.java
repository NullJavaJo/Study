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
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>네트워크 관련 요청 정보</h3>");
		out.print("Request Scheme : " + req.getScheme() + "<br/>");		// client가 웹서버에 서비스를 요청할 때 사용한 프로토콜 이름을 반환하는 메소드이다.
		out.print("Server Name : " + req.getServerName() + "<br/>");	// 서버의 호스트 이름을 반환하는 메소드이다. 별도의 이름이 없는 경우 IP주소를 반환한다.
		out.print("Server Address : " + req.getLocalAddr() + "<br/>");	// client로 부터 서비스를 요청받은 서버의 IP주소를 반환한다.
		out.print("Server Port : " + req.getServerPort() + "<br/>");	// Client의 서비스를 요청받아 처리하는 서버의 포트 번호를 반환한다.
		out.print("Client Address : " + req.getRemoteAddr() + "<br/>");	// 서비스를 요청한 client의 IP주소를 반환한다.
		out.print("Cleint Host : " + req.getRemoteHost() + "<br/>");	// 서비스를 요청한 client의 호스트 이름을 반환한다. 호스트의 이름이 없다면 IP주소를 반환한다.
		out.print("Client Port : " + req.getRemotePort() + "<br/>");	// 서비스를 요청한 클라이언트의 소스 포트 번호를 반환한다. 
		out.print("</body></html>");
		out.close();
		
		
	}
}
