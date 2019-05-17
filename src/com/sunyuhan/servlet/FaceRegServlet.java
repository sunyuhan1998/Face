package com.sunyuhan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunyuhan.dao.AcJDBCUtil;
import com.sunyuhan.dao.AcJDBCUtilImpl;

/**
 * Servlet implementation class FaceRegServlet
 */
public class FaceRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FaceRegServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String faceData = request.getParameter("imgData");
		AcJDBCUtil ac = new AcJDBCUtilImpl();
		PrintWriter pw = response.getWriter();
		String res = "";
		try {
			res = ac.setInformation(username,password,faceData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (res.trim().equals("ok")) {
			pw.write("×¢²á³É¹¦£¡");
		}else {
			pw.write("×¢²áÊ§°Ü");
		}
		pw.flush();
	}

}
