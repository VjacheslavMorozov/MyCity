package org.hillel.it.mycity.info;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;


public class Configuration {
	private static Configuration instance;
	String filePath;
	Properties prop;
	private Configuration() {
		filePath = new String();
		prop = new Properties();

	}
	public static Configuration getInstance() {
		if(instance == null) {
		    instance = new Configuration();
		}
		return instance;
	}
	public String getFilePath() {
		InputStream stream = Configuration.class.getClassLoader().getResourceAsStream("applications.propeties");
		try {
			prop.load(stream);
		} catch (IOException e) {
		}
		filePath = prop.getProperty("file.path");
		IOUtils.closeQuietly(stream);
		return filePath;
	}
}
