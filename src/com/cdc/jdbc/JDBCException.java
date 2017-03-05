package com.cdc.jdbc;
/**
 * jdbc异常类
 * @author cdc
 *
 */
public class JDBCException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5819253099503044897L;

	public JDBCException(String message) {
		super(message);
	}
}
