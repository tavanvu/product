package product.view;

import product.controller.ProductManager;
import product.model.Product;

import java.util.Scanner;

public class ProductMenu {
    private static ProductManager productManager = new ProductManager();

    public static ProductManager getProductManager() {
        return productManager;
    }

    public static void setProductManager(ProductManager productManager) {
        ProductMenu.productManager = productManager;
    }

    static {
        productManager.add(new Product("001", "Thịt lợn", "good", "Thịt", 500));
        productManager.add(new Product("002", "Thịt gà", "good", "Thịt", 400));
        productManager.add(new Product("003", "Rau cải", "good", "Rau", 100));
        productManager.add(new Product("004", "Rau muống", "good", "Rau", 100));
        productManager.add(new Product("005", "Quả cam", "good", "Quả", 200));
        productManager.add(new Product("006", "Quả táo", "good", "Quả", 200));
        productManager.add(new Product("007", "Thịt bò", "good", "Thịt", 1500));

    }

    public ProductMenu() {
    }

    int choice;

    public void run() {

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("mời bạn chọn số");
            Menu();
            try {
                choice = sc.nextInt();
                if (choice > 0 && choice < 10) {
                } else {
                    throw new RuntimeException("bạn đã nhập sai vui lòng chọn lại");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

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
                    category(sc);
                    break;
                case 6:
                    productManager.findByPriceMax();
                    break;
                case 7:
                    findByName(sc);
                    break;
                case 8:
                    productManager.input();
                    break;
                case 9:
                    productManager.output();
                    break;
                case 10:
                    productManager.sortProduct();


            }
        } while (choice != 0);
    }

    private void findByName(Scanner sc) {
        System.out.println("mời bạn nhập tên sản phẩm cần tìm");
        String name = sc.nextLine();
        productManager.findByPriceName(name);
    }

    private void category(Scanner sc) {
        int choice;
        String category;
        do {
            MenuCateGory();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    category = "Thịt";
                    productManager.find(category);
                    break;
                case 2:
                    category = "Rau";
                    productManager.find(category);
                    break;
                case 3:
                    category = "Quả";
                    productManager.find(category);
                    break;
            }
        } while (choice != 0);

    }

    private void MenuCateGory() {
        System.out.println("-----Phân Loại Gian Hàng----");
        System.out.println("1.Hàng Thịt");
        System.out.println("2.Hàng Rau");
        System.out.println("3.Hàng hoa quả");
        System.out.println("0.exit");
    }


    private static void deleteID(ProductManager productManager, Scanner sc) {
        System.out.println("mời bạn nhập id sản phẩm muốn xóa");
        String id = sc.nextLine();
        productManager.delete(id);
    }

    private static void updateByID(ProductManager productManager, Scanner sc) {
        System.out.println("mời bạn nhập id sản phẩm muốn cập nhập lại");
        String id = sc.nextLine();
        productManager.update(id, input());
    }

    private static void add(ProductManager productManager) {
        productManager.add(input());
    }

    private static Product input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("mời bạn nhập mã sản phẩm");
        String id = sc.nextLine();
        System.out.println("mời bạn nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("mời bạn nhập chất lượng sản phẩm");
        String prize = sc.nextLine();
        System.out.println("phân loại");
        String category = sc.nextLine();
        System.out.println("mời bạn nhập giá tiền");
        int price = sc.nextInt();
        Product product = new Product(id, name, prize, category, price);
        return product;
    }


    private static void show(ProductManager product) {
        product.show();
    }

    public static void Menu() {
        System.out.println("1.hiển thị tất cả sản phẩm");
        System.out.println("2.thêm sản phẩm");
        System.out.println("3.cập nhập sản phẩm");
        System.out.println("4. xóa sản phẩm");
        System.out.println("5.phân  loại");
        System.out.println("6.sản phẩm giá cao nhất");
        System.out.println("7.Tìm kiếm sản phẩm theo tên gần đúng )");
        System.out.println("8.đọc các sản phẩm trong file");
        System.out.println("9.ghi lại các sản phẩm trong file");
        System.out.println("0.exit");
    }
}
