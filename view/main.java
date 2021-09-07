package product.view;

import product.controller.productManager;
import product.model.product;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        productManager productManager = new productManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("mời bạn chọn số");
            Menu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    show(productManager);
                    break;
                case 2:
                    add(productManager);
                    break;
                case 3:
                    updateByID(productManager, sc);
                    break;
                case 4:
                    deleteID(productManager, sc);
                    break;
                case 5:
                    productManager.softPrice();
                    break;
                case 6:
                    productManager.findPriceMax();
                    break;
                case 7:
                    productManager.input();
                    break;
                case 8:
                    productManager.output();


            }
        } while (choice != 0);
    }

    private static void deleteID(productManager productManager, Scanner sc) {
        System.out.println("mời bạn nhập id sản phẩm muốn xóa");
        String id= sc.nextLine();
        productManager.delete(id);
    }

    private static void updateByID(productManager productManager, Scanner sc) {
        System.out.println("mời bạn nhập id sản phẩm muốn cập nhập lại");
        String id = sc.nextLine();
        productManager.update(id, input());
    }

    private static void add(productManager productManager) {
        productManager.add(input());
    }

    private static product input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("mời bạn nhập mã sản phẩm");
        String id = sc.nextLine();
        System.out.println("mời bạn nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("mời bạn nhập chất lượng sản phẩm");
        String prize = sc.nextLine();
        System.out.println("mời bạn nhập giá tiền");
        int price = sc.nextInt();
        System.out.println("mời bạn nhập số lượng sản phẩm");
        int quantity = sc.nextInt();
        product product = new product(id, name, prize, price, quantity);
        return product;
    }


    private static void show(productManager product) {
        product.show();
    }

    public static void Menu() {
        System.out.println("1.hiển thị tất cả sản phẩm");
        System.out.println("2.thêm sản phẩm");
        System.out.println("3.cập nhập sản phẩm");
        System.out.println("4. xóa sản phẩm");
        System.out.println("5.sắp xếp sản phẩm theo giá");
        System.out.println("6.sản phầm giá cao nhất");
        System.out.println("7.đọc các sản phẩm trong file");
        System.out.println("8.ghi lại các sản phẩm trong file");
        System.out.println("0.exit");
    }
}
