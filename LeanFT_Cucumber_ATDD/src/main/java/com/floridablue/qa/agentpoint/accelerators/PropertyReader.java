
package com.floridablue.qa.agentpoint.accelerators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class PropertyReader {
	
	 Properties properties = new Properties();
	 InputStream inputStreamConfig = null;
	 
	 public PropertyReader() {
		 
		 try{
			 inputStreamConfig = new FileInputStream("src\\main\\resources\\config.properties");
			 properties.load(inputStreamConfig);
		 }
		 
		 catch(IOException e){
			 e.printStackTrace();			 
		 }
	 }
	 
	 public String readProperty(String key){
		 
		 return properties.getProperty(key);
	 }
	 
	 public void setProperty(String key, String value){
		 
		 properties.setProperty(key, value);
	 }

}
