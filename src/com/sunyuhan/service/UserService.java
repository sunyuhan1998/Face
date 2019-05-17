package com.sunyuhan.service;
/**
*@author SunYuHan
*2019年2月26日下午6:15:23
*用户业务接口
*/
public interface UserService {
	//密码登录业务
	boolean LoginByPassword(String username,String password);

}
