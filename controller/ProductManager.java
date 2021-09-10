package product.controller;

import product.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements ReadAndWrite<Product>, Find<Product> {
    private List<Product> products = new ArrayList<>();

    static void add() {

    }

    public ProductManager() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void show() {
        int count = 0;
        for (Product product : products) {
            System.out.println(product);
            count++;
            if (count == 5) {
                count = 0;
                scanner.nextLine();
            }
        }
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(String id, Product product) {
        int index = findId(id);
        if (index != -1) {
            products.set(index, product);
        } else {
            System.out.println("Không có mã sản phẩm này");
        }
    }

    private int findId(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void delete(String id) {
        int index = findId(id);
        if (index != -1) {
            products.remove(index);
        } else {
            System.out.println("không có mã sản phẩm này");
        }
    }

    @Override
    public void findByPriceName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)) {
                System.out.println(products.get(i));
            }
        }
    }


    @Override
    public void findByPriceMax() {
        Product max = products.get(0);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() > max.getPrice()) {
                max = products.get(i);
            }
        }
        System.out.println(max);
    }

    @Override
    public void sortProduct() {
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = products.size() - 1; j > i; j--)
                if (products.get(j).getPrice() < products.get(j-1).getPrice()) {
                    Product temp = products.get(j);
//                    products.get(j) = products.get(j-1);
//                    products.get(j-1) = temp;
                }
        }
    }

    public void find(String category) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCategory().equals(category)) {
                System.out.println(products.get(i));
            }
        }
    }

    @Override
    public void output() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pro.txt"));
            oos.writeObject(products);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void input() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.txt"));
            List<Product> products = (List<Product>) ois.readObject();
            System.out.println(products);

        } catch (EOFException ex) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

