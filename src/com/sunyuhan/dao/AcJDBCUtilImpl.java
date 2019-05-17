package com.sunyuhan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


public class AcJDBCUtilImpl implements AcJDBCUtil{

	/**
	 * ע����
	 * ���û��������룬�������ݣ�
	 */
	@Override
	public String setInformation(String username, String password, String faceinfo) throws Exception {
		Connection conn = JDBCUtil.getConn();
		String sql = "insert into t_user VALUES(NULL,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, faceinfo);
		int index = ps.executeUpdate();
		if(index>0){
			System.out.println("��ӳɹ�");	
			return "ok";
		}else {
			System.out.println("���ʧ��");
			return "error";
		}
	}

	@Override
	/**
	 * �õ���������
	 */
	public Map<Integer, String> getAll() throws Exception {
		int i=0;
		Map<Integer,String> maps = new HashMap<Integer,String>();;
		Connection conn = JDBCUtil.getConn();
		String sql = "SELECT faceinfo FROM t_user";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String faceinfo = rs.getString("faceinfo");			
			maps.put(i, faceinfo);
			i++;			
		}
		return maps;
	}

}
