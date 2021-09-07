package product.model;

import java.io.Serializable;

public class product implements Serializable {
    private String Id, name, prize;
    private int price, quantity;

    public product() {
    }

    public product(String id, String name, String prize, int price, int quantity) {
        this.Id = id;
        this.name = name;
        this.prize = prize;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "product{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", prize='" + prize + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
