package com.cdc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class JDBCExecutor {
		//连接对象
		private Connection connection;
		//维护一个本类型的对象
		private static JDBCExecutor jdbcExecutor;
		//Statement对象,可以执行SQL语句并返回结果
		private Statement stmt;
		
		//私有构造器
		private JDBCExecutor() {
			try {
				PropertiesUtil.getJDBCProperties();
				//初始化JDBC驱动并让驱动加载到jvm中
				Class.forName(PropertiesUtil.JDBC_DRIVER);
				//创建数据库连接
				connection = DriverManager.getConnection(PropertiesUtil.JDBC_URL, PropertiesUtil.JDBC_USER, PropertiesUtil.JDBC_PASS);
				//创建Statement对象
				stmt =connection.createStatement();
			} catch (Exception e) {
				throw new JDBCException(e.getMessage());
			}
		}
		
		//提供一个静态方法返回本类的实例
		public static JDBCExecutor getJDBCExecutor() {
			//如果本类所维护jdbcExecutor属性为空,则调用私有的构造器获得实例
			if (jdbcExecutor == null) {
				jdbcExecutor = new JDBCExecutor();
			}
			return jdbcExecutor;
		}
		
		/**
		 * 计算数据总数
		 * @param sql
		 * @return
		 */
		public Integer count(String sql) {
			try {
				//利用Statement对象执行参数的sql
				ResultSet result = stmt.executeQuery(sql);
				result.next();
				Integer count = result.getInt(1);
				result.close();
				return count;
			} catch (Exception e) {
				e.printStackTrace();
				throw new QueryException(e.getMessage());
			}
		}
		
		/*
		 * 执行一句查询的sql
		 */
		public ResultSet executeQuery(String sql) {
			try {
				//利用Statement对象执行参数的sql
				ResultSet result = stmt.executeQuery(sql);
				return result;
			} catch (Exception e) {
				throw new QueryException(e.getMessage());
			}
		}
		
		//执行单句INSERT、UPDATE 或 DELETE 语句, 如果执行INSERT时, 返回主键
		public int executeUpdate(String sql) {
			int result = -1;
			try {
				//执行SQL语句
				stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
				//获得主键
				ResultSet rs = stmt.getGeneratedKeys();
				while(rs.next()) {
					//返回最后一个主键
					result = rs.getInt(1);
				}
				rs.close();
				return result;
			} catch (Exception e) {
				throw new QueryException(e.getMessage());
			}
		}

	}
