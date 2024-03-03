package fit.se.entity;
// {
//     "_id": 2,
//     "brand_name": "Ritchey",
//     "category_name": "Mountain Bikes",
//     "colors": [
//       "blue"
//     ],
//     "model_year": 2016,
//     "product_name": "Ritchey Timberwolf Frameset - 2016",
//     "price": 749.99
//   }

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Product {
	@SerializedName("_id")
    private long id;
	@SerializedName("brand_name")
    private String brandName;
	@SerializedName("category_name")
    private String categoryName;
    private List<String> colors;
    @SerializedName("model_year")
    private int modelYear;
    @SerializedName("product_name")
    private String productName;
    private double price;

    public Product() {
    }

    public Product(long id, String brandName, String categoryName, List<String> colors, int modelYear, String productName,
            double price) {
        this.id = id;
        this.brandName = brandName;
        this.categoryName = categoryName;
        this.colors = colors;
        this.modelYear = modelYear;
        this.productName = productName;
        this.price = price;
    }


    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [brandName=" + brandName + ", categoryName=" + categoryName + ", colors=" + colors + ", id=" + id
                + ", modelYear=" + modelYear + ", price=" + price + ", productName=" + productName + "]";
    }



}
