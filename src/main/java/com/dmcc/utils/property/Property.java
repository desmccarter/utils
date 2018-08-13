package com.dmcc.utils.property;

public class Property {

	public static String get(final String name){
		
		String value=null;
		
		if(name!=null){
			value =  System.getProperty(name);
		}
		
		return value;
	}
	
	public static boolean getBoolean(final String name){
		
		String value=get(name);
		
		boolean booleanValue=false;
		
		if(value!=null){
			booleanValue=value.trim().toUpperCase().equals("TRUE");
		}
		
		return booleanValue;
	}
}
