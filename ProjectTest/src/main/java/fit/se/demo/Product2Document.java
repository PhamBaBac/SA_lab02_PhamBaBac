package fit.se.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fit.se.dao.ProductDao;
import fit.se.entity.Product;

public class Product2Document {
	public static void main(String[] args) {
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		
		Gson gson = new Gson();
		
		String json = "{\r\n"
				+ "        \"_id\" : 1,\r\n"
				+ "        \"brand_name\" : \"Trek\",\r\n"
				+ "        \"category_name\" : \"Mountain Bikes\",\r\n"
				+ "        \"colors\" : [\r\n"
				+ "                \"red\",\r\n"
				+ "                \"yellow\",\r\n"
				+ "                \"blue\"\r\n"
				+ "        ],\r\n"
				+ "        \"model_year\" : 2016,\r\n"
				+ "        \"product_name\" : \"Trek 820 - 2016\",\r\n"
				+ "        \"price\" : 379.99\r\n"
				+ "}";
		
		Product p = gson.fromJson(json, Product.class);
		
		p.setId(1200l);
		p.setModelYear(2022);
		
		ProductDao productDao = new ProductDao();
		long id = productDao.insertProduct(p);
		System.out.println(id);
		
		
	}
}
