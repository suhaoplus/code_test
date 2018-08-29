package cn.xdl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	public static String md5Str(String password) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] md5Bytes = md.digest();
			for(int i=0;i<md5Bytes.length;i++) {
				byte md5Byte = md5Bytes[i];
				String tempStr = Integer.toHexString(md5Byte&0xff);
				if(tempStr.length()==1) {
					tempStr ="0"+tempStr;
				}
				sb.append(tempStr).reverse();
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
