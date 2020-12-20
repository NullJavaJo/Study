package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerInfo")
public class HeaderInfoSerlvet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		// HTTP 프로토콜의 요청정보는 헤더(header)와 몸체(body)로 구성되어 있고, 헤더의 두번쨰 줄 이후부터는 "name:value"형태로 헤더의 정보들이 들어있다. 
		res.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>요청 헤더 정보</h3>");
		Enumeration<String> em = req.getHeaderNames();					/*req.getHeaderNames()는 요청정보의 헤더 안에 있는 정보중 헤더 이름들만 모아 Enumeration객체에 담아 반환하고, 
																		반환된 값의 시작주소를 em 변수에 저장한다. Enumeration객ㅇ체는 java.util 패키지에 속해있고, 배열처럼 데이터 그룹으로 구성된
																		Collection객체이다. 
																		Enumeration객체가 Set, List, Map Collection 객체와 다른점은 그룹의 데이터에 접근할 때 인덱스나 키가 아닌
																		커서라는 개념으로 접근한다는 사실이다. req.getHeaderNames()가 헤더 정보의 이름들을 String 타입으로 Enumeration객체에
																		담아 반환하면 Enumeration객체의 첫번째 요소 앞에 커서가 위치한다. 
																		그 외에 커서의 개념으로 접근하는 collection객체에는 Iterator가 있으며 주로 모든 요소들을 차례로 접근할 때 사용하면 편리하고, 속도도 빠르다.*/
		while(em.hasMoreElements()) {									// em.hasMoreElements()는 em이 가리키는 Enumeration객체의 커서 다음에 데이터가 있는지 없는지 판단해서 boolean리턴
			String s = em.nextElement();								// em.nextElement()는 em의 커서 다음에 있는 요소를 반환하고 다음 요소로 커서를 이동시킨다. 
			out.println(s + " : " + req.getHeader(s) + "<br/>");		// s에는 요청정보의 헤더 이름이 들어있는데, 헤더이름을 getHeader()의 인자로 지정하면 해당 이름을 찾아 반환한다. 즉, getHeader()는 헤더의 값을 추출하는 메소드이다. 
		}
		out.print("</body></html>");
		out.close();
		
		
	}
}
