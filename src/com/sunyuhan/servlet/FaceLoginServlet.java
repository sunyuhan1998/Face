package com.sunyuhan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sunyuhan.dao.AcJDBCUtilImpl;
import com.sunyuhan.domain.Result;
import com.sunyuhan.face.FaceDetect;
import com.sunyuhan.face.FaceMatch;
import com.sunyuhan.util.ResultUtil;

/**
 * ����ʶ���½servlet
 */
public class FaceLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FaceLoginServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String imgData = request.getParameter("imgData");
		//��ȡ�����
		Map<Integer, String> faceLib = null;
		try {
			faceLib = new AcJDBCUtilImpl().getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//����Ա�
		Result rs = new Result();
		PrintWriter pw = response.getWriter();
		for (int i = 0;i<faceLib.size();i++) {
			String face = faceLib.get(i);
			String result = FaceMatch.match(face, imgData);
			//�����쳣
			if(result.trim().equals("error")) {
				rs.setFlag(false);
				pw.write(JSON.toJSONString(rs));
				pw.flush();
				System.out.println("�쳣");
				return;
			}
			//����ͨ��
			double score = Double.parseDouble(result.trim());
			if (score>80) {
				String detect = FaceDetect.detect(imgData);
				
				String sex = ResultUtil.getSex(detect);
				String sc = ResultUtil.getScore(detect);
				String exp = ResultUtil.getExp(detect);
				String type = ResultUtil.getType(detect);
				
				rs.setUsername("admin");
				rs.setFlag(true);
				rs.setSex(sex);
				rs.setSc(sc);
				rs.setExp(exp);
				rs.setType(type);
				
				System.out.println(rs.getSex());
				System.out.println(rs.getSc());
				System.out.println(rs.getExp());
				System.out.println(rs.getType());
				
				pw.write(JSON.toJSONString(rs));
				pw.flush();
				return;
			}
		}
		//û��Ȩ��
		rs.setUsername("strangeness");
		rs.setFlag(false);
		pw.write(JSON.toJSONString(rs));
		pw.flush();
		return;
	}

}
