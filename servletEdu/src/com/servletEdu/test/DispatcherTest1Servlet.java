package com.servletEdu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3> Dispatcher Test1의 수행결과<h3>");
		
		ServletContext sc = this.getServletContext();		
		//ServletContext객체를 추출하는 이유는 ServletContext에서 제공하는 
		//RequestDispatcher를 생성하기 위한 메소드를 사용하기 위해서이다. 
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");
		//ServletContext의 getRequestDispatcher를 사용해 RequestDispatcher객체를
		//생성한 후 반환받는다. 반환된 rd는 "/dispatcher2"라는 path값을 가진다.
		//rd.forward(req, resp);
		rd.include(req, resp);
		out.close();	//close가 되면서 자동으로 flush해주는데 forward는 이동해버리기 때문에
		//close메소드를 실행하지 못하고 끝나버리고, include는 다시 돌아와 실행하기 때문에 2개 다 출력
	}
}
