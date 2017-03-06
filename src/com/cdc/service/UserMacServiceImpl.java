package com.cdc.service;

import java.util.Collection;
import com.cdc.dao.UserMacDaoImpl;
import com.cdc.model.UserMac;

public class UserMacServiceImpl implements UserMacService {
	
	private UserMacDaoImpl  userMacDaoImpl;
	
	
	public UserMacServiceImpl(UserMacDaoImpl  userMacDaoImpl) {
		this.userMacDaoImpl=userMacDaoImpl;
	}

	
	@Override
	public Collection<UserMac> getUserMacByUser(String userName) {
		// TODO Auto-generated method stub
		return userMacDaoImpl.findUserMacByUser(userName);
	}

	@Override
	public Collection<UserMac> getUserMacByMac(String mac) {
		// TODO Auto-generated method stub
		return userMacDaoImpl.findUserMacByMac(mac);
	}

}
