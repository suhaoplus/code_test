package cn.xdl.factroy;

import cn.xdl.esms.dao.AddressDAO;

public class AddressDAOFactory {

	public AddressDAO getAddressDAO() {
		String str = "cn.xdl.esms.dao.imp.AddressDaoImpl";
		try {
			return (AddressDAO) Class.forName(str).newInstance();
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
