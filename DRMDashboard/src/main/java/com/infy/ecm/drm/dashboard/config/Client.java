package com.infy.ecm.drm.dashboard.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Client {

	@SuppressWarnings("resource")
	public static MongoDatabase getDataBase(String datadabseName) {
		MongoDatabase db = null;
		try {
			String dbUri = "mongodb://krupamay:krupamay@ds033116.mlab.com:33116/krupadb";
			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbUri));

			//MongoClient mongoClient = new MongoClient("localhost", 27017);//local
			db = mongoClient.getDatabase(datadabseName);
			System.out.println(db.toString());
			System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return db;
	}

}
