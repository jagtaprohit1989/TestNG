package TestNGFramework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
	Properties prop;
	
	public Properties readProp() throws IOException {
		FileInputStream fis=new FileInputStream("src/test/Resources/config.properties");
		prop=new Properties();
		prop.load(fis);
		return prop; 
	}

}
