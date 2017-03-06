package com.cdc.model;
/**
 * select userno,password,macno,TERMINALID,
 * TER_LOGINNO,USERCODE,username,C_USERINFO.platlevel as c_platlevel,
 * TB_MCTM_USER_TERMINAL.platlevel as t_platlevel from C_USERINFO,
 * TB_MCTM_USER_TERMINAL where C_USERINFO.userno=TB_MCTM_USER_TERMINAL.userid 
 * and userno='iFaboo_TY_MPAD022';
 * @author cdc
 *
 */
public class UserMac {
	
	public UserMac(){
		
	}
	
	public UserMac(String userno,String password,String macno,String terminalid,String ter_loginno,String usercode,String username,String c_platlevel,String t_platlevel){
		this.userno=userno;
		this.password=password;
		this.macno=macno;
		this.terminalid=terminalid;
		this.ter_loginno=ter_loginno;
		this.usercode=usercode;
		this.username=username;
		this.c_platlevel=c_platlevel;
		this.t_platlevel=t_platlevel;
	}
	
	private String userno;
	private String password;
	private String macno;
	private String terminalid;
	private String ter_loginno;
	private String usercode;
	private String username;
	private String c_platlevel;
	private String t_platlevel;
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMacno() {
		return macno;
	}
	public void setMacno(String macno) {
		this.macno = macno;
	}
	public String getTerminalid() {
		return terminalid;
	}
	public void setTerminalid(String terminalid) {
		this.terminalid = terminalid;
	}
	public String getTer_loginno() {
		return ter_loginno;
	}
	public void setTer_loginno(String ter_loginno) {
		this.ter_loginno = ter_loginno;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getC_platlevel() {
		return c_platlevel;
	}
	public void setC_platlevel(String c_platlevel) {
		this.c_platlevel = c_platlevel;
	}
	public String getT_platlevel() {
		return t_platlevel;
	}
	public void setT_platlevel(String t_platlevel) {
		this.t_platlevel = t_platlevel;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder  stringBuilder=new StringBuilder();
		stringBuilder.append("userno="+userno);
		stringBuilder.append("password="+password);
		stringBuilder.append("macno="+macno);
		stringBuilder.append("terminalid="+terminalid);
		stringBuilder.append("ter_loginno="+ter_loginno);
		stringBuilder.append("usercode="+usercode);
		stringBuilder.append("username="+username);
		stringBuilder.append("c_platlevel="+c_platlevel);
		stringBuilder.append("t_platlevel="+t_platlevel);
		return stringBuilder.toString();
	}
	

}
