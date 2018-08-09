package cn.xdl.test;

import java.sql.Connection;



import cn.xdl.util.DBCPUtil;

public class DBCPUtilTest {
	


	public static void main(String[] args) {
		
		Connection conn = DBCPUtil.getConnection();
		System.out.println(conn);

	}

}
