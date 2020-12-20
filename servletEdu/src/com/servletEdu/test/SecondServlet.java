package com.servletEdu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("SecondServlet!!");
	} //실행결과 SecondServlet!!
	/*
	 *		/second.로 요청하면 SecondServlet의 init()메소드가 실행되어야 하는데, 재정의하지 않아서 GenericServlet 클래스의 init()메소드가 실행된다. 
	 *		그리고 service()메소드도 재정의 되지 않아서 GenericServlet클래스를 상속받아 구현한 HttpServlet클래스의  service(ServletRequest, ServletResponse)메소드가 실행되고 
	 *		이 메소드는 HttpSerlvet클래스의 service(HttpServletRequest, HttpServletResponse)메소드를호출한다. 그리고 이 메소드는 다시 SecondServlet클래스의 doGet()메소드를 호출하여 실행한다. 
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("SecondServlet!!");
		PrintWriter out = resp.getWriter();		//resp를 통해 응답관련 처리라는것을 알 수 있고, 데이터를 출력하기 위한 출력스트림을 추출하는 메소드이다. 이를 통해 out을 통해 client에게 데이터를 출력할 수 있다
		out.print("<html><head><title>Test</title></head>");	//서버가 문자열을 보내는 응답정보 안에 어떤 타입의 문서를 보낸다고 설정하는 부분이 없다. 그럴경우 기본값인 text/html로 처리한다. 즉 모두 HTML태그로 인식하여 처리한다고 보면 된다.
		out.print("<body><h1>have a nice day!!</h1></body>");
		out.print("</html>");
		out.close();	//out이라는 이름의 스트림을 닫아주는 메소드이다. 즉 resp.getWriter()를 이용하여 웹브라우저와 웹서버간에 연결된 출력스트림을 끊어주는 명령문이다.  
	}
	
}
