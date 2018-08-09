package cn.xdl.factroy;

import cn.xdl.esms.dao.NewsDAO;

public class NewsDAOFactory {

	public NewsDAO getNewsDAO() {
		String str = "cn.xdl.esms.dao.imp.NewsDaoImpl";
		try {
			return (NewsDAO) Class.forName(str).newInstance();
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
