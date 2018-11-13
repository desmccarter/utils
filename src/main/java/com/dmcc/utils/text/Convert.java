package com.dmcc.utils.text;

import static com.dmcc.utils.io.Io.debug;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convert {
	
	public static String removeNonAlphaNumericCharacters(final String value){
		String description=value;
		
		if(description!=null){
			Pattern pattern = Pattern.compile("([^A-Z|a-z|0-9| |\t]*)([A-Z|a-z|0-9| |\t]*)([^A-Z|a-z|0-9| |\t]*)");
	        Matcher matcher = pattern.matcher(description);
	        
	        while (matcher.find()) {
	            String prevalue = matcher.group(1);
	            String midvalue = matcher.group(2);
	            String postvalue = matcher.group(3);
	            
	            description=description.replace(prevalue+midvalue+postvalue, midvalue);
	        }
		}
	
		return description;
	}
	
	public static String toCamelCase(final String value){
		String description=value;
		
		if(description!=null){
			Pattern pattern = Pattern.compile("([^A-Z|^a-z|^0-9])([a-z])");
	        Matcher matcher = pattern.matcher(description);
	        
	        while (matcher.find()) {
	            String prevalue = matcher.group(1);
	            String charvalue = matcher.group(2);
	            
	            if(!prevalue.equals(" ")){
	            	description = description.replace(prevalue+charvalue, prevalue+" "+charvalue.toUpperCase());
	            }
	            else
	            {
	            	description = description.replace(prevalue+charvalue, prevalue+" "+charvalue.toUpperCase());
	            }
	        }

			pattern = Pattern.compile("^([^A-Z|^a-z]*)([a-z])(.*)$");
	        matcher = pattern.matcher(description);

	        if (matcher.find()) {
	            String prevalue = matcher.group(1);
	            String midvalue = matcher.group(2);
	            String postvalue = matcher.group(3);
	          
	            description = description.replace(prevalue+midvalue+postvalue, prevalue+midvalue.toUpperCase()+postvalue);
	        }
	        
			pattern = Pattern.compile("^([^0-9]*)([0-9]+)([^0-9]*)");
	        matcher = pattern.matcher(description);

	        while(matcher.find()) {
	            String prevalue = matcher.group(1);
	            String midvalue = matcher.group(2);
	            String postvalue = matcher.group(3);
	          
	            description = description.replace(prevalue+midvalue+postvalue, prevalue+" "+midvalue+postvalue);
	        }
	        
			pattern = Pattern.compile("([a-z])([A-Z])");
	        matcher = pattern.matcher(description);

	        while(matcher.find()) {
	            String prevalue = matcher.group(1);
	            String postvalue = matcher.group(2);

	            description = description.replace(prevalue+postvalue, prevalue+" "+postvalue);
	        }
		}
			
		return description;
	}
}
