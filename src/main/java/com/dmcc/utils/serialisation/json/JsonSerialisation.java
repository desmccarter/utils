package com.dmcc.utils.serialisation.json;

import static com.dmcc.utils.io.Io.debug;
import static com.dmcc.utils.io.Io.error;

import com.dmcc.utils.exceptions.UtilsException;
import com.dmcc.utils.file.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerialisation {

	public static Object deserialiseFileAsClassInstance(final String file, final Class theClass)
	throws UtilsException {
		try {
				debug("Deserialising file to JSON ("+theClass+") :"+file);
			
				String theJson = FileUtil.readText(file);
				
				ObjectMapper mapper =  new ObjectMapper();
				
				return  mapper.readValue(theJson, theClass);
			} catch (Exception e) {
				error(e.getMessage());
				throw new UtilsException(e.getMessage());
			} 
		}
}
