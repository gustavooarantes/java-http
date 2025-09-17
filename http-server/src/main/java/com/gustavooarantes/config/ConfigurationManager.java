package com.gustavooarantes.config;

public class ConfigurationManager {

	private static ConfigurationManager myConfigurationManager;

	private ConfigurationManager() {

	}

	public static ConfigurationManager getInstance() {
		if (myConfigurationManager == null)
			myConfigurationManager = new ConfigurationManager();
		return myConfigurationManager;
	}

	/**
	 * Used to loead a configuration file by the path provided
	 */
	public void loadConfigurationFile(String filePath) {

	}
}
