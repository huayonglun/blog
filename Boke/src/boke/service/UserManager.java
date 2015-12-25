package boke.service;

import boke.po.User;

public interface UserManager {

	/**
	 * 管理员登�?	 * @param username 管理员用户名
	 * @param password 管理员密�?	 * @return
	 */
	boolean login(String username,String password);
	
	//通过ID去找user
	public User getUserById(Integer i);
	 
	void insert(String username,String password);
}
