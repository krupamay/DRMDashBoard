package com.infy.ecm.drm.dashboard.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.ecm.drm.dashboard.config.Client;
import com.infy.ecm.drm.dashboard.model.BurnDownInput;
import com.infy.ecm.drm.dashboard.model.BurnDownInputResponse;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DashBoardDaoImpl implements DashBoardDao {

//	@SuppressWarnings("resource")
//	public static MongoDatabase getDataBase(String datadabseName) {
//		MongoDatabase db = null;
//		try {
////			String dbUri = "mongodb://krupa:krupa@localhost:27027";
////			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbUri));
//			MongoClient mongoClient = new MongoClient("localhost", 27017);
//
//			db = mongoClient.getDatabase(datadabseName);
//			System.out.println(db.toString());
//			System.out.println("success");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return db;
//	}
	
	private MongoDatabase db = Client.getDataBase("krupadb");

	private MongoCollection<Document> collection = db.getCollection("DashBoard");

	public void InsertDailyData(BurnDownInput burnDownInput) {
		System.out.println("Inside Dao");
		ObjectMapper mapper = new ObjectMapper();

		try {
			Document doc = Document.parse(mapper.writeValueAsString(burnDownInput));
			collection.insertOne(doc);
			System.out.println("Successsfully insrted");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public BurnDownInputResponse getBurnDownData(String sprint, String team) {
		List<BurnDownInput> list = new ArrayList<BurnDownInput>();
		BurnDownInputResponse result = new BurnDownInputResponse();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("sprint", sprint));
		obj.add(new BasicDBObject("team", team));
		andQuery.put("$and", obj);
		System.out.println(andQuery.toString());
		MongoCursor<Document> mongoCursor = collection.find(andQuery).iterator();
		
		while (mongoCursor.hasNext()) {
			String str = mongoCursor.next().toJson();
			System.out.println(str);
			try {
				BurnDownInput burnDownInput = mapper.readValue(str, BurnDownInput.class);
				list.add(burnDownInput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("here");
		result.setResponse(list);;
		System.out.println(result);
		return result;
	}

}
