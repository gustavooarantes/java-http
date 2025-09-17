package com.gustavooarantes.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
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
		StringBuilder sb = new StringBuilder();

		try (FileReader fileReader = new FileReader(filePath)) {
			int i;
			while ((i = fileReader.read()) != -1) {
				sb.append((char) i);
			}
		} catch (FileNotFoundException e) {
			throw new HttpConfigurationException(e);
		} catch (IOException e) {
			throw new HttpConfigurationException(e);
		}

		JsonNode conf;
		try {
			conf = Json.parse(sb.toString());
		} catch (IOException e) {
			throw new HttpConfigurationException("Parsing error: ", e);
		}

		try {
			currentConfiguration = Json.fromJson(conf, Configuration.class);
		} catch (JsonProcessingException e) {
			throw new HttpConfigurationException("Parsing error (internal): ", e);
		}
	}

	/**
	 * Returns the current loaded configuration
	 */
	public Configuration getCurrentConfiguration() {
		if (currentConfiguration == null) {
			throw new HttpConfigurationException("No current configuration was found.");
		}

		return currentConfiguration;
	}
}
