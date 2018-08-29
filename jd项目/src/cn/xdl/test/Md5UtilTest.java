package cn.xdl.test;

import cn.xdl.util.Md5Util;

public class Md5UtilTest {

	public static void main(String[] args) {
		String str = Md5Util.md5Str("1234");
		System.out.println(str);
	}
	
}
