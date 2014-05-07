package org.hillel.it.mycity.info;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;


public class Configuration {
	private static Configuration instance;
	Properties prop;
	private Configuration() {
		prop = new Properties();
	}
	
	public static Configuration getInstance() {
		if(instance == null) {
		    instance = new Configuration();
		}
		return instance;
	}
	
	public String getFilePath() {
		InputStream stream = Configuration.class.getClassLoader().getResourceAsStream("application.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
		}
		String filePath = prop.getProperty("file.path");
		IOUtils.closeQuietly(stream);
		return filePath;
	}
	
	public String getUrl() {
		InputStream stream = Configuration.class.getClassLoader().getResourceAsStream("application.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
		}
		String url = prop.getProperty("data.url");
		IOUtils.closeQuietly(stream);
		return url;
	}
	
	public int getMaxConnCount() {
		InputStream stream = Configuration.class.getClassLoader().getResourceAsStream("application.properties");
		try {
			prop.load(stream);
		} catch (IOException e) {
		}
		int mcc = Integer.parseInt(prop.getProperty("maxConnCount"));
		IOUtils.closeQuietly(stream);
		return mcc;
	}
}
