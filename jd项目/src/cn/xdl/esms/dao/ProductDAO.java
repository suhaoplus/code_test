package cn.xdl.esms.dao;

import java.util.List;

import cn.xdl.esms.bean.Product;

public interface ProductDAO {

	List<Product> findProductByParentId(int cotegory_id);

	List<Product> findProductList(int category_id, String orderStd, String orderType, int pageNumber, int pageSize);


	Product findProductDetailById(int product_id);
	
	List<Product> findProductByKeyWord(String keyWord);
}
