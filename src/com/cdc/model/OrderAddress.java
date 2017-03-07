package com.cdc.model;

public class OrderAddress {
	private String name;
	
	private String urlPath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	
	
	public OrderAddress(String name,String urlPath){
		this.name=name;
		this.urlPath=urlPath;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(name);
		//stringBuilder.append("urlPath="+urlPath);
		return stringBuilder.toString();
	}

}
