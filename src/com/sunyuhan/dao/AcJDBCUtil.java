package com.sunyuhan.dao;

import java.util.Map;

public interface AcJDBCUtil {
	//�õ�base64����
	//�û���
	//����
	String setInformation(String username ,String password,String faceinfo) throws Exception;
	
	Map<Integer,String> getAll() throws Exception;
	

}
