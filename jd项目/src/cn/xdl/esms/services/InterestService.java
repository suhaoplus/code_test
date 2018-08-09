package cn.xdl.esms.services;

import java.sql.Timestamp;
import java.util.Map;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.dao.InterestDAO;
import cn.xdl.factroy.InterestDAOFactory;

public class InterestService {

	private InterestDAO interestDao;

	public InterestService() {
		interestDao = new InterestDAOFactory().getInterestDAO();
	}
	//向收藏表中增加商品
	public boolean insertInterest(int user_id, int product_id, String bak) {
		return interestDao.insertInterest(user_id, product_id,bak);
	}

	//查询是否存在该商品
	public boolean selectInterest(int product_id) {
		return interestDao.selectInterest(product_id);
	}

	//联合查询产品和收藏时间
	public Map<Product,Timestamp> findInterestAll(){
		return interestDao.findInterestAll();
	}

	//根据产品ID删除收藏
	public boolean delInterestByProductId(int product_id) {
		return interestDao.delInterestByProductId(product_id);
	}

}
