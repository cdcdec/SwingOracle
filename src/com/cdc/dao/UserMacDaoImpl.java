package com.cdc.dao;

import java.util.ArrayList;
import java.util.List;

import com.cdc.model.UserMac;

public class UserMacDaoImpl extends BaseDaoImpl implements UserMacDao {

	@Override
	public List<UserMac> findUserMacByUser(String userName) {
		StringBuilder sql = new StringBuilder("select userno,password,macno,TERMINALID,TER_LOGINNO,USERCODE,username,C_USERINFO.platlevel as c_platlevel,TB_MCTM_USER_TERMINAL.platlevel as t_platlevel from C_USERINFO,TB_MCTM_USER_TERMINAL where C_USERINFO.userno=TB_MCTM_USER_TERMINAL.userid and userno=");
		sql.append("'");
		sql.append(userName);
		sql.append("'");
		List<UserMac> lists=(List<UserMac>) getDatas(sql.toString(), new ArrayList<Object>(), UserMac.class);
		return lists;
	}

	@Override
	public List<UserMac> findUserMacByMac(String mac) {
		StringBuilder sql = new StringBuilder("select userno,password,macno,TERMINALID,TER_LOGINNO,USERCODE,username,C_USERINFO.platlevel as c_platlevel,TB_MCTM_USER_TERMINAL.platlevel as t_platlevel from C_USERINFO,TB_MCTM_USER_TERMINAL where C_USERINFO.userno=TB_MCTM_USER_TERMINAL.userid and macno=");
		sql.append("'");
		sql.append(mac);
		sql.append("'");
		List<UserMac> lists=(List<UserMac>) getDatas(sql.toString(), new ArrayList<Object>(), UserMac.class);
		return lists;
	}
	
	public static void main(String[] args) {
		UserMacDaoImpl  userMacDaoImpl=new UserMacDaoImpl();
		List<UserMac> lists =userMacDaoImpl.findUserMacByMac("900917068081");
		if(lists!=null && lists.size()>0){
			System.out.println(lists.get(0).toString());
		}else{
			System.out.println("======");
		}
		
	}
}
