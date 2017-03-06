package com.cdc.dao;

import java.util.List;

import com.cdc.model.UserMac;

public interface UserMacDao {
	List<UserMac> findUserMacByUser(String user);
	List<UserMac> findUserMacByMac(String user);
	
	
	

}
