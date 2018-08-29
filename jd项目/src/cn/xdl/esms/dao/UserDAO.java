package cn.xdl.esms.dao;

import cn.xdl.esms.bean.User;


public interface UserDAO {

	int insertUser(User user);

	boolean findUserByLoginName(String login_name);


	User findUser(String login_name, String password);
	
	boolean update(String login_name, String oldpassword, String newpassword);
	
	boolean updateNick(String value, int user_id);
	
	User findUser(String login_name);
}
