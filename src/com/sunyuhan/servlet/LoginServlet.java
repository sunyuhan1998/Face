package com.sunyuhan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunyuhan
 * ����ʶ��Ӧ�� �����¼servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//��������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		if(username.equals("admin")&&password.equals("admin")) {
			pw.write("����Ա����½�ɹ�");
		}else {
			pw.write("�˺Ż��������");
		}
		pw.flush();
	}
}
