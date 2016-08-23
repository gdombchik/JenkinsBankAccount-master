package com.jenkins.PropertyManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

	private String phantomJSDriver;

	public void generateProperty(){
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = this.getClass().getClassLoader().getResourceAsStream("com/jenkins/PropertyManager/parameters.properties");
			prop.load(input);
			
			setPhantomJSDriver(prop.get("phantomJSDriver").toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getPhantomJSDriver() {
		return phantomJSDriver;
	}

	public void setPhantomJSDriver(String phantomJSDriver) {
		this.phantomJSDriver = phantomJSDriver;
	}
}
