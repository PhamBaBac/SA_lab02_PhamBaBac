package fit.se.dao;
/**
 * Đây là lớp mô tả thông tin Win

 */
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import com.mongodb.client.result.InsertOneResult;

import static com.mongodb.client.model.Filters.*;

import fit.se.db.Connection;
import fit.se.entity.Product;

public class ProductDao {
    	
	private static final Gson GSON = new Gson();
	private MongoCollection<Document> collection;
	
	public ProductDao() {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
		MongoDatabase db = mongoClient.getDatabase("BikeStores");
		collection = db.getCollection("products");
	}
	
	public long insertProduct(Product p) {
		
		String json = GSON.toJson(p);
		
		Document doc = Document.parse(json);
		
		InsertOneResult oneResult = collection.insertOne(doc);
		
		return oneResult.getInsertedId().asInt32().longValue();
	}
	
//	 db.products.findOne({_id:1200})
	public Product findProductById(long id) {
		
		Document doc = collection.find(eq("_id", id)).first();
		if(doc != null) {
			String json = doc.toJson();
			Product p = GSON.fromJson(json, Product.class);
			
			return p;
		}
		
		return null;
	}
	
}
