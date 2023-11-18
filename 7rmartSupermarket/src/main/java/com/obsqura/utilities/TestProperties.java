package com.obsqura.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.obsqura.constants.Constants;

public class TestProperties {
	
	public static Properties getProperties() throws IOException {
		
		//properties class
				Properties prop =new Properties();
				FileInputStream fis = new FileInputStream(Constants.configfilePath);
				prop.load(fis);
				return prop;
	}

}
