package fit.se.demo;

import fit.se.dao.ProductDao;
import fit.se.entity.Product;

public class InsertProduct {
	public static void main(String[] args) {
		
		ProductDao productDao = new ProductDao();
		
		Product p = productDao.findProductById(145l);
		
		System.out.println(p);
		
	}
}

