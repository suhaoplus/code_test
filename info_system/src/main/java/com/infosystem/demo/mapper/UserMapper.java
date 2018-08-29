package com.infosystem.demo.mapper;


import com.infosystem.demo.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int insertUser(UserInfo user) throws Exception;
	/**
	 * 修改用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	//public int updateUser(@Param("user") UserInfo user,@Param("id") int id) throws Exception;
	public int updateUser(UserInfo user) throws Exception;
	/**
	 * 删除用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(int id) throws Exception;
	/**
	 * 通过ID查询用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserInfo findUserById(int id) throws Exception;
	/**
	 * 查询所有用户信息
	 * @return
	 * @throws Exception
	 */
	public List<UserInfo> findAllUser() throws Exception;

	/**
	 * 登录
	 * @param params
	 * @return
	 */
    public UserInfo findUser(Map<String,Object> params);
}
