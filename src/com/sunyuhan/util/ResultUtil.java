package com.sunyuhan.util;
/**
*@author SunYuHan
*2019年2月27日下午6:30:36
*
*/
public class ResultUtil {
	//获取性别
	public static String getSex(String img) {
		int rs = img.indexOf("male");
		if (rs>0) {
			return "男";
		}
		return "女";
		
	}
	//获取脸种类
	public static String getType(String img) {
		int rs = img.indexOf("human");
		if (rs>0) {
			return "真实人脸";
		}
		return "动画 人脸";
	}
	//获取表情
	public static String getExp(String img) {
		int rs = img.indexOf("smile");
		int rs2 = img.indexOf("laugh");
		if (rs>0) {
			return "微笑";
		}else if(rs2>0) {
			return "大笑";
		}
		return "不笑";
	}
	//获取颜值
	public static String getScore(String img) {
		img = img.substring(img.indexOf("beauty")+8,img.indexOf("expression")-2);
		return img;
	}
	

}
