package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Util {

	public static Map loadFile() {

		Map<String, String> parametri = new HashMap<String, String>();
		// File configFile = new File("agenda.properties");
		File configFile = new File("prop.xml");
		try {
			// FileReader reader = new FileReader(configFile);
			// Properties props = new Properties();
			// props.load(reader);
			// InputStream inputStream = new FileInputStream(configFile);
			// props.load(inputStream);
			// props.loadFromXML(inputStream);
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream("prop.xml");
			props.loadFromXML(fis);
			// props.list(System.out);
			String user = props.getProperty("user");
			String url = props.getProperty("url");
			// String host = props.getProperty("pin");
			parametri.put("user", user);
			parametri.put("url", url);
			parametri.put("pin", props.getProperty("pin"));
			parametri.put("pass", props.getProperty("password"));
			// System.out.print("user name is: " + user);
			// inputStream.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex1) {
			// I/O error
		}
		return parametri;
	}
}
