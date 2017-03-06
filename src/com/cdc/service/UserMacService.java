package com.cdc.service;

import java.util.Collection;

import com.cdc.model.UserMac;

public interface UserMacService {
	Collection<UserMac> getUserMacByUser(String userName);
	Collection<UserMac> getUserMacByMac(String mac);

}
