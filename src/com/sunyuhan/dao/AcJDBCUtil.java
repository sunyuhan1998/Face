package com.sunyuhan.dao;

import java.util.Map;

public interface AcJDBCUtil {
	//得到base64编码
	//用户名
	//密码
	String setInformation(String username ,String password,String faceinfo) throws Exception;
	
	Map<Integer,String> getAll() throws Exception;
	

}
