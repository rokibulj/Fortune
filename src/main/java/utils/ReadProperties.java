package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {

	public String getProperty(String key) {
		String value = null;
		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);

		if (value == null) {
			String currentEnv = prop.getProperty("testEnv");
			prop = loadProperty(currentEnv);
			value = prop.getProperty(key);
		}

		return value;
	}

	public String getSaucelabsProperty(String key) {
		String value = null;
		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);

		return value;
	}

	private Properties loadProperty(String propFilename) {
		Properties prop = new Properties();

		String filePath = "./src/main/resources/properties/" + propFilename + ".properties";

		try {
			File file = new File(filePath);
			FileInputStream stream = new FileInputStream(file);
			prop.load(stream);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return prop;
	}

}
