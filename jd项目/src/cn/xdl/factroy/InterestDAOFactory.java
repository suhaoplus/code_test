package cn.xdl.factroy;

import cn.xdl.esms.dao.InterestDAO;

public class InterestDAOFactory {

	public InterestDAO getInterestDAO() {
		String str = "cn.xdl.esms.dao.imp.InterestDaoImpl";
		try {
			return (InterestDAO)Class.forName(str).newInstance();
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
