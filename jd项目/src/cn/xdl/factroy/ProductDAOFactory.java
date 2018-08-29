package cn.xdl.factroy;

import cn.xdl.esms.dao.ProductDAO;

public class ProductDAOFactory {

	public ProductDAO getProductDAO() {
		//return new ProductDAO_Oracle_Imp();
		String str = "cn.xdl.esms.dao.imp.ProductDaoImpl";
		try {
			return (ProductDAO) Class.forName(str).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
