package fit.se.dao;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.result.InsertOneResult;

import fit.se.db.Connection;
import fit.se.entity.Staff;

public class StaffDao {

	private static final Gson GSON = new Gson();
	private MongoCollection<Document> collection;

	public StaffDao() {
		MongoClient mongoClient = Connection.getInstance().getMongoClient();
		MongoDatabase db = mongoClient.getDatabase("BikeStore");
		collection = db.getCollection("staffs");
	}

	public long insertStaff(Staff staff) {

		String json2 = GSON.toJson(staff);

		Document doc = Document.parse(json2);

		long managerId = doc.get("manager", Document.class).getInteger("_id");
		doc.remove("manager");
		doc.append("manager_id", managerId);

		InsertOneResult rs = collection.insertOne(doc);
		
		return rs.getInsertedId().asInt32().longValue();
	}
	
//	db.staffs.findOne({_id:2})
	public Staff findStaffById(long id) {
		
		Document doc = collection.find(eq("_id", id)).first();
		
		if(doc != null) {
			Document temp = collection.find(eq("_id", doc.get("manager_id", Number.class))).first();
			doc.remove("manager_id");
			doc.append("manager", temp);

			String json = doc.toJson();
			
			return GSON.fromJson(json, Staff.class);
		}
		
		return null;
	}

}
