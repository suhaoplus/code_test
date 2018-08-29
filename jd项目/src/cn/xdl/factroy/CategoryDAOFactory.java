package cn.xdl.factroy;

import cn.xdl.esms.dao.CategoryDAO;

public class CategoryDAOFactory {

	public static CategoryDAO getCategoryDAO() {
		//return new CategoryDAO_Oracle_Imp();
		String str="cn.xdl.esms.dao.imp.CategoryDaoImpl";
		try {
			return (CategoryDAO) Class.forName(str).newInstance();
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
