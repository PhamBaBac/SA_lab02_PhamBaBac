package fit.se.demo;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fit.se.dao.StaffDao;
import fit.se.entity.Phone;
import fit.se.entity.Staff;

public class Staff2Document {
	public static void main(String[] args) {
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		
		Gson gson = new Gson();
		
		String json = "{\r\n"
				+ "        \"_id\" : 1,\r\n"
				+ "        \"first_name\" : \"Fabiola\",\r\n"
				+ "        \"last_name\" : \"Jackson\",\r\n"
				+ "        \"phone\" : {\r\n"
				+ "                \"type\" : \"personal\",\r\n"
				+ "                \"number\" : \"(831) 555-5554\"\r\n"
				+ "        },\r\n"
				+ "        \"email\" : \"fabiola.jackson@bikes.shop\"\r\n"
				+ "}";
		
		Staff staff = gson.fromJson(json, Staff.class);
		System.out.println(staff);
		
		Staff newStaff = new Staff(1001l, "sdfsd", "sdf", new Phone("home", "234324"), "sdfsd@gmail.com", staff);
		
		String json2 = gson.toJson(newStaff);
		
		
		Document doc = Document.parse(json2);
		
		long managerId = doc.get("manager", Document.class).getInteger("_id");
		doc.remove("manager");
		doc.append("manager_id", managerId);
		
		System.out.println(doc);
		
		StaffDao staffDao = new StaffDao();
		
		long id = staffDao.insertStaff(newStaff);
		System.out.println(id);
		
		
		
	}
}
