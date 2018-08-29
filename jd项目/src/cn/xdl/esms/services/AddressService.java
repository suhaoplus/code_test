package cn.xdl.esms.services;

import java.util.List;

import cn.xdl.esms.bean.Address;
import cn.xdl.esms.dao.AddressDAO;
import cn.xdl.factroy.AddressDAOFactory;

public class AddressService {

	private AddressDAO addressDao;
	public AddressService() {
		addressDao = new AddressDAOFactory().getAddressDAO();
	}
	public boolean insertAddr(int user_id, String receive_name, String province, String address,
			String zipcode, String mobile, String telephone, String email, String area) {
		return addressDao.insertAddr(user_id, receive_name, province, address, zipcode, mobile, telephone, email, area);
	}
	
	public List<Address> findAddrAll(){
		return addressDao.findAddrAll();
	}
}
