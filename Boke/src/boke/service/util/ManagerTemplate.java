package boke.service.util;

import boke.dao.ResourceDao;
import boke.dao.ResourceTypeDao;
import boke.dao.UserDao;

public class ManagerTemplate {
	protected UserDao userDao;

	protected ResourceTypeDao resourceTypeDao;
	
	
	protected ResourceDao resourceDao;
	
	

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public ResourceTypeDao getResourceTypeDao() {
		return resourceTypeDao;
	}

	public void setResourceTypeDao(ResourceTypeDao resourceTypeDao) {
		this.resourceTypeDao = resourceTypeDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
