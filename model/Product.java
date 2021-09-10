package product.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String Id, name, prize,category;
    private int price;


    public Product(String id, String name, String prize,String category, int price) {
        this.Id = id;
        this.name = name;
        this.prize = prize;
        this.price = price;
        this.category=category;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Id=" + Id + '\'' + "|" +
                "name=" + name + '\'' + "|" +
                "prize=" + prize + '\'' + "|" +
                "price=" + price + "|";
    }
}
