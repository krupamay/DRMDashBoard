package com.infy.ecm.drm.dashboard.config;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

public class Client {

	public static DatabaseClient getClient() {
		DatabaseClient client = DatabaseClientFactory.newClient(Config.host, Config.port, Config.user, Config.password,
				Config.authType);
		return client;
	}
}
