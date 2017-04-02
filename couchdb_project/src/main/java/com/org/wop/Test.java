package com.org.wop;

import org.lightcouch.Attachment;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Document;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Test 
{
	public static void test1()
	{
//		CouchDbClient dbClient1 = new CouchDbClient("database1", true, "http", "127.0.0.1", 5984, null, null);
//		System.out.println(dbClient1.toString());
//		
////		JsonObject user1 = new JsonObject();
////		user1.addProperty("username", "login1");
////		
////		JsonObject user2 = new JsonObject();
////		user2.addProperty("username", "login2");
////		
////		dbClient1.save(user1);
////		dbClient1.save(user2);
//		
//		JsonObject user1 = dbClient1.find(JsonObject.class, "42a68749e1b14f9baaa519631bb5d07c");
//		JsonElement username = user1.get("username");
//		String login = username.getAsString();
//		System.out.println(login);
//		
//		dbClient1.shutdown();
		
		CouchDbClient albums = new CouchDbClient("albums", true, "http", "127.0.0.1", 5984, null, null);
		System.out.println(albums.toString());
		
		JsonObject doc1 = albums.find(JsonObject.class, "d7a34ee5993b1dbbc00cf4fd9e0012e7");
		JsonElement str = doc1.get("item");
		String item = str.getAsString();
		System.out.println(item);
		
		Document appleDoc = new Document();
		GsonBuilder gsonBuilder = new GsonBuilder();
		Attachment attachement = new Attachment();
		
		albums.shutdown();
	}
}
