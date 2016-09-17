package com.infy.ecm.drm.dashboard.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static Properties props = loadProperties();
	
	protected static String host = props.getProperty("drm.host");
	
	protected static int port = Integer.parseInt(props.getProperty("drm.port"));
	
	protected static String user = props.getProperty("drm.writer_user");
	
	protected static String password = props.getProperty("drm.writer_password");
	
	protected static String admin_user = props.getProperty("drm.admin_user");
	
	protected static String admin_password = props.getProperty("drm.admin_password");
	

	// get the configuration for the drm
	private static Properties loadProperties() {		
	    try {
			String propsName = "Config.properties";
			InputStream propsStream =
				Config.class.getClassLoader().getResourceAsStream(propsName);
			if (propsStream == null)
				throw new IOException("Could not read config properties");

			Properties props = new Properties();
			props.load(propsStream);

			return props;

	    } catch (final IOException exc) {
	        throw new Error(exc);
	    }  
	}
}
