package cn.xdl.esms.dao;

import java.sql.Timestamp;
import java.util.Map;

import cn.xdl.esms.bean.Product;

public interface InterestDAO {

	boolean insertInterest(int user_id, int product_id, String bak);
	
	boolean selectInterest(int product_id);
	
	Map<Product,Timestamp> findInterestAll();
	
	boolean delInterestByProductId(int product_id);
}
