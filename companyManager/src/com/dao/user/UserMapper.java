package com.dao.user;

import com.pojo.User;

public interface UserMapper {
	/**
	 * 获得登录用户
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(User user)throws Exception;

	/**
	 * 登录帐号是否存在
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int loginCodeIsExit(User user)throws Exception;
	/**
	 * 用户修改最后
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modifyUser(User user )throws Exception;
	
	
	
	/**
	 * 添加用户
	 * @return
	 * @throws Exception
	 */
	public int addUser(User user )throws Exception;


}
