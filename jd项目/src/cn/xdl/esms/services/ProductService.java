package cn.xdl.esms.services;

import java.util.List;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.dao.ProductDAO;
import cn.xdl.factroy.ProductDAOFactory;

public class ProductService {

	private ProductDAO productDao;

	public ProductService() {
		productDao = new ProductDAOFactory().getProductDAO();
	}
	public List<Product> findProductByCategoryId(int cotegory_id){
		return productDao.findProductByParentId(cotegory_id);
	}
	
	public List<Product> showProductList(int category_id,String orderStd,String orderType,int pageNumber, int pageSize){
		return productDao.findProductList(category_id, orderStd, orderType, pageNumber, pageSize);
	}
	
	public Product showProductDetail(int product_id) {
		return productDao.findProductDetailById(product_id);
	}
	
	public List<Product> findProductByKeyWord(String keyWord){
		return productDao.findProductByKeyWord(keyWord);
	}
	
	
}
