package com.sunyuhan.util;
/**
*@author SunYuHan
*2019��2��27������6:30:36
*
*/
public class ResultUtil {
	//��ȡ�Ա�
	public static String getSex(String img) {
		int rs = img.indexOf("male");
		if (rs>0) {
			return "��";
		}
		return "Ů";
		
	}
	//��ȡ������
	public static String getType(String img) {
		int rs = img.indexOf("human");
		if (rs>0) {
			return "��ʵ����";
		}
		return "���� ����";
	}
	//��ȡ����
	public static String getExp(String img) {
		int rs = img.indexOf("smile");
		int rs2 = img.indexOf("laugh");
		if (rs>0) {
			return "΢Ц";
		}else if(rs2>0) {
			return "��Ц";
		}
		return "��Ц";
	}
	//��ȡ��ֵ
	public static String getScore(String img) {
		img = img.substring(img.indexOf("beauty")+8,img.indexOf("expression")-2);
		return img;
	}
	

}
