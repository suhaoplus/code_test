package com.infosystem.demo.controller;

import java.util.List;

import com.infosystem.demo.domain.UserInfo;
import com.infosystem.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

//找到所有的用户信息
	@RequestMapping(value = "/findAllUser")
	public List<UserInfo> findAllUser() throws Exception {
		List<UserInfo> userInfoList = userMapper.findAllUser();
		return userInfoList;
	}

	//删除指定用户
	@RequestMapping("/deleteUserInfo")
	public boolean deleteUserInfo(@RequestParam(value = "id") int id) throws Exception {
		userMapper.deleteUser(id);
		return true;
	}

	//插入用户
	@RequestMapping("/insertUserInfo")
	public boolean addUserInfo(@RequestParam(value = "name") String name,
							   @RequestParam(value = "password") String password,
							   @RequestParam(value = "info") String info) throws Exception {
		UserInfo user = new UserInfo(name,password,info);
		userMapper.insertUser(user);
		return true;
	}

	//修改用户
	@RequestMapping("/updateUserInfo")
	public boolean editUserInfo(@RequestParam(value = "id")int id,
								@RequestParam(value = "name") String name,
								@RequestParam(value = "password") String password,
								@RequestParam(value = "info") String info
	) throws Exception {
		UserInfo user = new UserInfo(id,name,password,info);
		userMapper.updateUser(user);
		return true;
	}
}
