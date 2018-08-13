package com.dmcc.utils.io;

public class Io {

	private static String getFormat(){
		return "[%-6s] %-60s\n";
	}
	
	private static void stdout(final String prefix, final String text){
		System.out.printf(getFormat(),prefix,text);
	}
	
	private static void stderr(final String prefix, final String text){
		System.err.printf(getFormat(),prefix,text);
	}	
	
	public static void debug(final String text){
		stdout("DEBUG",text);
	}
	
	public static void info(final String text){
		stdout("INFO",text);
	}
	
	public static void warn(final String text){
		stdout("WARN",text);
	}
	
	public static void error(final String text){
		stderr("ERR",text);
	}
}
