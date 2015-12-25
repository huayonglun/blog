package boke.service.impl;

import boke.po.User;
import boke.service.UserManager;
import boke.service.util.ManagerTemplate;

public class UserManagerImpl extends ManagerTemplate implements UserManager {
	
	@Override
	public boolean login(String username, String password) {
		User user = null;
		user =  this.getUserDao().get(username);
		if(user==null){
			return false;
		}
		//System.out.println(user.getName());
		if(user.getPassword().equals(password))
		return true;
		return false;
	}

	@Override
	public User getUserById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(String username, String password) {
		User user = new User(16,"gh","gh");
		System.out.println(username+password);
		//user.setName(username);
	//	user.setPassword(password);
		System.out.println("123");
		String str = this.getUserDao().save(user);
		System.out.println(str);
	}

	
	
}
