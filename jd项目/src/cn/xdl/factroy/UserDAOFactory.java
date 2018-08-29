package cn.xdl.factroy;

import cn.xdl.esms.dao.UserDAO;
/**
 * DAO工厂类
 * @author cz
 *
 */
public class UserDAOFactory {

	public static UserDAO getUserDAO() {
		//return new UserDAO_Oracle_Imp();
		String str = "cn.xdl.esms.dao.imp.UserDaoImpl";
		try {
			return (UserDAO) Class.forName(str).newInstance();
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
