package com.cdc.jdbc;
/**
 * 数据库查询异常类
 * @author cdc
 *
 */
public class QueryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1542509006521281556L;
	public QueryException(String message) {
		super(message);
	}

}
