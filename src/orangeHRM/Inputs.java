package orangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Inputs {

public static String fileInputs( String key ) throws IOException {
	File fi = new File("D:\\sss\\My Testing Projects\\orangeHRM\\Testing Inputs\\inputs");
	FileInputStream fs = new FileInputStream(fi);
	Properties config = new Properties();
	config.load(fs);
	return config.getProperty(key);
}
	
}
