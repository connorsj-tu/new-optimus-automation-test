package com.common.helpers;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class housing various static utility functions for the rest of the application
 */
public class Utils {
	
	private static Properties config;
	static {
		String configFilePath = System.getenv("CONFIG_PROPERTIES_FILE");
		if (StringUtils.trimToNull(configFilePath) == null) {
			configFilePath = System.getProperty("user.dir")+"/config.properties";
		}
		else configFilePath = System.getProperty("user.dir")+"/" + configFilePath;
		config = new Properties();
		try(FileInputStream file = new FileInputStream(configFilePath)) {
		    config.load(file);
		} catch (IOException e) {
			System.err.println("IOException caught: " + e.toString());
		}
	}
	
	/**
	 * First checks environment variables for property. If that isn't
	 * found, then checks in the configuration file. If that is also not
	 * found, then it gives the default value.
	 * 
	 * @param key The environment variable / configuration property name
	 * @param defaultValue The value to return if the key value is not found
	 * @return The value of System.getenv, Configuration.getProperty, or defaultValue
	 */
	public static String getProperty(String key, String defaultValue) {
		String value;
		value = System.getenv(key);
		if (StringUtils.trimToNull(value) == null) {
			value = config.getProperty(key, defaultValue);
		}
		return value;
	}
	
	/**
	 * Overrides key/defaultValue getProperty call using null as the default
	 * value.
	 */
	public static String getProperty(String key) {
		return getProperty(key, null);
	}



}
