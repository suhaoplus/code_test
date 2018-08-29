package cn.xdl.test;

import java.util.List;

import cn.xdl.esms.bean.Product;
import cn.xdl.esms.dao.ProductDAO;
import cn.xdl.esms.dao.imp.ProductDaoImpl;

public class ProductDAOTest {

	public static void main(String[] args) {
		
		ProductDAO p = new ProductDaoImpl();
		List<Product> list = p.findProductList(21, "lower_price", "desc", 1, 3);
		for(Product pro :list) {
			System.out.println(pro);
		}

	}

}
