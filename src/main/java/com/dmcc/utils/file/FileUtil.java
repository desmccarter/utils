package com.dmcc.utils.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.dmcc.utils.exceptions.UtilsException;

public class FileUtil {

	public static void writeText(final String text, final String file) throws UtilsException {
		
		if( (file==null) || (file.length()==0) ){
			// No null/empty filenames ..
			throw new UtilsException("[ERR] File name is null");
		}
		
	    BufferedWriter writer=null;
	    
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			// Failed to open file ..
			throw new UtilsException("[ERR] Failed to open "+file+" for writing:\n"+e.getMessage());
		}
		
	    try {
			writer.write(text);
		} catch (IOException e) {
			// Failed to write to file ..
			throw new UtilsException("[ERR] Failed to write to file "+file+":\n"+e.getMessage());
		}
	     
	    try {
			writer.close();
		} catch (IOException e) {
			// Failed to write to file ..
			throw new UtilsException("[ERR] Failed to close file "+file+":\n"+e.getMessage());
		}		
	}
	
	public static String readText(final String file) throws UtilsException {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(file));

			  return new String(encoded);
		} catch (IOException e) {
			throw new UtilsException(e.getMessage());
		}
	}

}
