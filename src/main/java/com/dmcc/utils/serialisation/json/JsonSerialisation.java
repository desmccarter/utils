package com.dmcc.utils.serialisation.json;

import static com.dmcc.utils.io.Io.debug;

import java.io.IOException;
import java.util.List;
import com.dmcc.utils.exceptions.UtilsException;
import com.dmcc.utils.file.FileUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dmcc.utils.exceptions.UtilsException;

import static com.dmcc.utils.io.Io.debug;

public class JsonSerialisation {

	public static Object deserialiseFileAsClassInstance(final String file, final Class theClass)
	throws UtilsException {
		try {
				debug("Deserialising file to JSON ("+theClass+") :"+file);
			
				String theJson = FileUtil.readText(file);
				
				ObjectMapper mapper =  new ObjectMapper();
				
				return  mapper.readValue(theJson, theClass);
			} catch (JsonParseException e) {
				throw new UtilsException(e.getMessage());
			} catch (JsonMappingException e) {
				throw new UtilsException(e.getMessage());
			} catch (IOException e) {
				throw new UtilsException(e.getMessage());
			}
	}
}
