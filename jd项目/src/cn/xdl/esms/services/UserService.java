package cn.xdl.esms.services;

import cn.xdl.esms.bean.User;
import cn.xdl.esms.dao.UserDAO;
import cn.xdl.factroy.UserDAOFactory;
/**
 * 用户类的服务类，调用UserDAO_Oracle_Imp类中的方法
 * @author cz
 *
 */
public class UserService {
	//创建dao接口实现类对象
	private UserDAO userDao;
	public UserService() {
		userDao=new UserDAOFactory().getUserDAO();
	}
	/**
	 * 用户注册的业务方法
	 * @param user  存有用户登录名、密码、邮箱、推荐人的user
	 * @return    数据库用户表操作的影响行数
	 */
	public boolean register(User user) {
		return userDao.insertUser(user)==1?true:false;

	}
	/**
	 * 验证推荐人是否存在的业务方法
	 * @param login_name  推荐人的登录名
	 * @return    查询结果true为存在该用户，false表示不存在该用户
	 */
	public boolean checkUserLoginName(String login_name) {
		return userDao.findUserByLoginName(login_name);
	}
	
	/*public boolean login(String login_name,String password) {
		return userDao.findUser(login_name, password);
	}*/

	public User login(String login_name,String password) {
		return userDao.findUser(login_name, password);
	}

	public boolean update(String login_name,String oldpassword,String newpassword) {
		return userDao.update(login_name, oldpassword, newpassword);
	}

	public boolean updateNick(String value,int  user_id) {
		return userDao.updateNick(value, user_id);
	}

	public User findUserByLoginName(String login_name) {
		return userDao.findUser(login_name);
	}
}


































































