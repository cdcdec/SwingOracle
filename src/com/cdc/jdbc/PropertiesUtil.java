package com.cdc.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取数据库配置文件
 * @author cdc
 *
 */
public class PropertiesUtil {
		//属性列表
		private static Properties properties = new Properties();
		/**
		 * 配置文件的路径
		 * 必需在src的cfg目录下
		 */
		private static String CONFIG1 = "/cfg/mysql.properties";
		private static String CONFIG2 = "/cfg/mysql.properties";
		//读取资源文件, 设置输入流
		private static InputStream is;
		//数据库驱动
		public static String JDBC_DRIVER;
		//jdbc连接url
		public static String JDBC_URL;
		//数据库用户名
		public static String JDBC_USER;
		//数据库密码
		public static String JDBC_PASS;
		public static int dataBaseNum=1;
		static {
			try {
				if(dataBaseNum==1){
					is = PropertiesUtil.class.getResourceAsStream(CONFIG1);
				}else if(dataBaseNum==2){
					is = PropertiesUtil.class.getResourceAsStream(CONFIG2);
				}
				//加载输入流
				properties.load(is);
				//获得配置的各个属性
				JDBC_DRIVER = properties.getProperty("jdbc.driver");
				JDBC_URL = properties.getProperty("jdbc.url");
				JDBC_USER = properties.getProperty("jdbc.user");
				JDBC_PASS = properties.getProperty("jdbc.pass");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
