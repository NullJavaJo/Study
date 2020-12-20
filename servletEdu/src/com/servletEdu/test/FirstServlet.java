package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; //servlet을 작성하기 위해 꼭 상속받아야 하는 HttpServlet 클래스가 있는 패키지를 포함하는 소스이다. Servlet을 작성하기 위해서는 반드시 HttpServlet, GenericServlet, Servlet중 하나를 상속받아야한다.

@WebServlet("/hello2")	//web.xml을 통한 방법외에도 어노테이션을 통한 접근도 있는데 그것이 @WebServlet("접근시 사용할 URI")이다. 어노테이션을 사용하기 위해서는 import javax.servlet.annotation.WebServlet;을 클래스 소스로 추가해주어야만한다. 
public class FirstServlet extends HttpServlet{
	//HttpSerlvet에 선언된 메소드들은 doGet, doPost, doPut, doDelete등이 있는데, 예를들어 클라이언트가 GET방식으로 요청하면 doGet()을, POST방식이라면 doPost()를 호출한다고 보면된다.
	//service()를재정의 할지 doGet(), doPost()를 재정의 할지는 개발상황에 따라 선택하면되는데 꼭구분해야하는 경우가 있다.
	//클라이언트가 무언가 작성하게 서버에 제출해야하는 서비스가 있을 떄 한번 제출한 상태에서 새로고침을 누르면 두번제출되는 경우가 있따. 이런경우에는 이를 예방하기위해 POSt방식으로 요청하고 doPost()에 서비스 처리를 구현하면된다.
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{	//서블릿이 최초로 호출되었을 떄 서블릿 컨테이너가 자동으로 실행하는 메소드인 init메소드이다. 
		System.out.println("init() 실행됨!");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException{	//클라이언트의 요청이 있을 때 마다 매번 서블릿 컨테이너가 자동으로 실행하는 service메소드이다. 
		System.out.println("service() 실행됨!");
	}
	/*
	 * callback method는 어떤 객체에 어떤 상황이 발생하면 컨테이너가 자동으로 호출하여 실행되는 메소드를 말한다. 이런 콜백 메소드들이 서블릿을 실행한다.
	 * HttpServlet클래스를 상속받은 다음 재정의한 init(), service()가 콜백 메소드에 속한다. 
	 * 그리고 GenericServlet클래스에 선언되어 있는 destroy() 메소드도 콜백 메소드이다. 
	 * init()은 최초로 서블릿요청이 있을 떄 '단 한번' 실행되고, service()는 클라이언트의 요청이 있을때 마다 실행된다. destroy()는 서블릿 객체가 메모리에서 삭제 될 때 즉, 서비스나 서버가 중지될 떄 실행된다.destroy()는자원해체 작업이다. 
	 */
	
	
	/*
	 * web.xml에서 servlet태그를 이용해 설정을 해준뒤 실행하면 위의 init, service메소드가 실행된다. 
	 * 그리고 웹브라우저를 새로고침할 때마다 service메소드의 'service() 실행됨!'이 콘솔에 출력된다. 
	 * 위에서 말했듯 init메소드는 최초 처음만 실행되기 때문이다. 
	 */
}
