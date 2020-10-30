package utils;

import application.MainApp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	private static final String FOLDER = "properties/";

	public static Properties loadProperties(String path) {
		Properties prop = new Properties();
		try {
			prop.load(MainApp.class.getClassLoader().getResourceAsStream(FOLDER + path));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static Properties loadProperties(InputStream input) {
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			System.out.println("unable to read the file: " + input.getClass());
		}
		return prop;
	}
}