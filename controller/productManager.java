package product.controller;

import product.model.product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class productManager implements General<product> {
    List<product> products = new ArrayList<>();


    @Override
    public void show() {
        for (product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void add(product product) {
        products.add(product);
    }

    @Override
    public void update(String id, product product) {
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
    public void softPrice() {
//        for (int i = 0; i < products.size() - 1; i++) {
//            for (int j = products.size() - 1; j > i; j--)
//                if (products.get(j).getPrice() < products.get(j - 1).getPrice()) {
//                    product temp = products.get(j);
//                    products.get(j) = products.get(j - 1);
//                    products.get(j - 1) = temp;
//                }
//        }
    }

    @Override
    public int findPriceMax() {
        int max = products.get(0).getPrice();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() > max) {
                max = products.get(i).getPrice();
            }
        }
        System.out.println(max);
        return max;
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pro.txt"));
            List<product> products = (List<product>) ois.readObject();
            System.out.println(products);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
