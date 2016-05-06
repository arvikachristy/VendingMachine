package sample;

/**
 * Created by User on 05/05/2016.
 */
public class Product {
    private int quantity;
    private double price;
    private String key;

    public Product(String key, int quantity, double price){
        this.key=key;
        this.quantity=quantity;
        this.price=price;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getKey(){
        return key;
    }

}
