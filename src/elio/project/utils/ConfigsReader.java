package elio.project.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	private static Properties prop;

	public static void readProperties(String filepath) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static String  getProperty(String key) {
		return prop.getProperty(key);
	}

}
