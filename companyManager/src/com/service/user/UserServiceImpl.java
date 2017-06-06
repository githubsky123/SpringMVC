package com.service.user;

import javax.annotation.Resource;

import com.dao.user.UserMapper;
import com.pojo.User;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Override
	public User getLoginUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.getLoginUser(user);
	}
	/**
	 * 登录帐号是否存在
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public int loginCodeIsExit(User user)throws Exception{
		return userMapper.loginCodeIsExit(user);
	}
	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}
	@Override
	public int modifyUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.modifyUser(user);
	}

}
