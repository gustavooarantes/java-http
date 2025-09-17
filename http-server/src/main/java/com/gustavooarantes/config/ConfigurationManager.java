package com.gustavooarantes.config;

import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.gustavooarantes.util.Json;

public class ConfigurationManager {

	private static ConfigurationManager configurationManager;
	private static Configuration currentConfiguration;

	private ConfigurationManager() {

	}

	public static ConfigurationManager getInstance() {
		if (configurationManager == null)
			configurationManager = new ConfigurationManager();
		return configurationManager;
	}

	/**
	 * Used to load a configuration file by the path provided
	 */
	public void loadConfigurationFile(String filePath) throws IOException {
		FileReader fileReader = new FileReader(filePath);
		StringBuffer sb = new StringBuffer();

		int i;
		while ((i = fileReader.read()) != -1) {
			sb.append((char) i);
		}

		JsonNode conf = Json.parse(sb.toString());
		currentConfiguration = Json.fromJson(conf, Configuration.class);

		fileReader.close();
	}

	/**
	 * Returns the current loaded configuration
	 */
	public void getCurrentConfiguration() {

	}
}
