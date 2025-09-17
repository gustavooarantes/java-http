package com.gustavooarantes;

import com.gustavooarantes.config.Configuration;
import com.gustavooarantes.config.ConfigurationManager;
import com.gustavooarantes.config.HttpConfigurationException;

public class HttpServer {

	public static void main(String[] args) {

		System.out.println("Server starting...");

		try {
			ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
		} catch (Exception e) {
			throw new HttpConfigurationException(e);
		}

		try {
			Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
		} catch (Exception e) {
			throw new HttpConfigurationException(e);
		}
	}
}
