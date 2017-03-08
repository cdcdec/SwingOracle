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
		private  static Properties properties;
		/**
		 * 配置文件的路径
		 * 必需在src的cfg目录下
		 */
		private  static String CONFIG1 = "/config/oracle1.properties";
		private  static String CONFIG2 = "/config/oracle2.properties";
		//读取资源文件, 设置输入流
		private static  InputStream is;
		//数据库驱动
		public static  String JDBC_DRIVER;
		//jdbc连接url
		public static  String JDBC_URL;
		//数据库用户名
		public static  String JDBC_USER;
		
		public  static String dataBaseName="local";
		
		//数据库密码
		public static  String JDBC_PASS;
//		static {
//			try {
//				is = PropertiesUtil.class.getResourceAsStream(CONFIG1);
//				//加载输入流
//				properties.load(is);
//				//获得配置的各个属性
//				JDBC_DRIVER = properties.getProperty("jdbc.driver");
//				JDBC_URL = properties.getProperty("jdbc.url");
//				System.out.println("JDBC_URL="+JDBC_URL);
//				JDBC_USER = properties.getProperty("jdbc.user");
//				JDBC_PASS = properties.getProperty("jdbc.pass");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	
		public static void getJDBCProperties(){
			try {
				properties = new Properties();
				
				String dataBaseName=PropertiesUtil.dataBaseName;
				System.out.println("dataBaseName="+dataBaseName);
				if("local".equals(dataBaseName)){
					System.out.println("dataBaseName_local="+dataBaseName);
					is = PropertiesUtil.class.getResourceAsStream(CONFIG1);
				}else if("root".equals(dataBaseName)){
					System.out.println("dataBaseName_root="+dataBaseName);
					is = PropertiesUtil.class.getResourceAsStream(CONFIG2);
				}
				//加载输入流
				properties.load(is);
				//获得配置的各个属性
				JDBC_DRIVER = properties.getProperty("jdbc.driver");
				JDBC_URL = properties.getProperty("jdbc.url");
				System.out.println("JDBC_URL="+JDBC_URL);
				JDBC_USER = properties.getProperty("jdbc.user");
				JDBC_PASS = properties.getProperty("jdbc.pass");
				System.out.println("dri="+JDBC_DRIVER+",url="+JDBC_URL+",u="+JDBC_USER+",="+JDBC_PASS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		

}
