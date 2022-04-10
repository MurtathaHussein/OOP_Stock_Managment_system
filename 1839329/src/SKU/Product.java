package SKU;

public class Product {
    private String SKU;
    private String description;
    private int price;
    public Product(String sKU, String description, int price) {
        this.SKU = sKU;
        this.description = description;
        this.price = price;
    }
    public Product() {
    }
    public String getSKU() {
        return SKU;
    }
    public void setSKU(String sKU) {
        SKU = sKU;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [SKU=" + SKU + ", description=" + description + ", price=" + price + "]";
    }


}