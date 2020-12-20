package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/addInfo")
public class AdditionalInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		res.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>추가적인 요청 정보</h3>");
		out.print("Request Method : " + req.getMethod() + "<br/>");		/* client는 여러가지 요청방식을 지정하여 서비스를 요청할 수 있다. 이때 지정한 요청방식은 요청정보의 헤더에 첫번째 줄에 첫번째단어로 
																		표시되어 전달된다. req.getMethod()는 이부분의 정보를 추출하는 메소드이다. 즉, 클라이언트의 요청방식을 추출하는 메소드이다. 
																		요청방식의 default는 GET이다. */
		out.print("Path Info : " + req.getPathInfo() + "<br/>");	// uri에서 urlpattern 다음에 오는 값들을 반환한다.
		out.print("Path Translated : " + req.getPathTranslated() + "<br/>");	// path info의 경로를 물리적인 경로로 변환하여 반환한다.
		out.print("Query String : " + req.getQueryString() + "<br/>");	/* req.getQueryString은 요청 URL에서 ?를 찾아 ? 뒤에있는 문자열전체를 추출하여 반환한다. 예를 들어
																		http://localhost:8080/servletEdu/addInfo?name=null&addr=java 로 요청한다면 name=null&addr=java를 반환함*/
		out.print("Content Length : " + req.getContentLength() + "<br/>");	/* client가 서버에 서비스를 요청했다는 것은 HTTP요청정보를 보냈다는것이다. 요청정보는 header와 body로 구성되어있는데, 
																			req.getContentLength는 요청정보 body에 있는 데이터의 길이를 추출하고 아래의 req.getContentType은 body에 있는
																			데이터의 문서타입을 추출한다. 여기서 이 두메소드의 반환값을 주목하자*/			
		out.print("Content Type : " + req.getContentType() + "<br/>");	// 서비스를 요청한 client의 호스트 이름을 반환한다. 호스트의 이름이 없다면 IP주소를 반환한다.
		out.print("</body></html>");
		out.close();
		
		
	}
}
