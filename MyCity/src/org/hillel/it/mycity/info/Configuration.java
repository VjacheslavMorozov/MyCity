package org.hillel.it.mycity.info;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;


public class Configuration {
	private static Configuration instance;
	private Configuration() {}
	public static Configuration getInstance() {
		if(instance == null) {
		    instance = new Configuration();
		}
		return instance;
	}
	public void getFilePath() throws IOException {
		InputStream stream = Configuration.class.getClassLoader().getResourceAsStream("applications.propeties");
		List<String> linesList = IOUtils.readLines(stream);
		for(String line : linesList) {
			System.out.println(line);
		}
		IOUtils.closeQuietly(stream);
	}
}
