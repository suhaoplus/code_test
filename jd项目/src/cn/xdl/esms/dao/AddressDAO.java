package cn.xdl.esms.dao;

import java.util.List;

import cn.xdl.esms.bean.Address;

public interface AddressDAO {

	boolean insertAddr(int user_id, String receive_name, String province, String address,
                       String zipcode, String mobile, String telephone, String email, String area);
	
	List<Address> findAddrAll();
}
