package com.crm.vitiger.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author NAGASHREE
 *
 */
public class FileUtility {
	public String getPropertyKeyValue(String key) throws Throwable 
		{
			FileInputStream file=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
			Properties prop=new Properties();
			prop.load(file);
			
			return prop.getProperty(key);
	}
}