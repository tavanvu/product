package product.view;

import product.controller.UserManager;
import product.model.User;

import java.util.Scanner;

public class LoginMenu {
    public static UserManager userManager = new UserManager();
    Scanner scanner = new Scanner(System.in);


    private void menugeneral() {
        System.out.println("---MENU QUẢN LÍ TÀI KHOẢN NGƯỜI DÙNG---");
        System.out.println("-----------------------");
        System.out.println("1.hiển thị thông tin tài khoản");
        System.out.println("2.chỉnh sửa tài khoản");
        System.out.println("3.xóa tài khoản");
        System.out.println("0.exit");
    }

    int choice;
    public void Run() {
        do {
            System.out.println("mời bạn chọn");
            Menu();
            try {
                choice = scanner.nextInt();
                if (choice>0 &&choice<3){
                }else {
                    throw new RuntimeException("mời bạn nhập lại");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

            scanner.nextLine();
            switch (choice) {
                case 1:
                    doLogin();
                    break;
                case 2:
                    doRegister();
                    break;
            }

        } while (choice != 0);
    }

    private void doLogin() {
        System.out.println("Đăng nhập....");
        System.out.println("Nhập username:");
        String username = scanner.nextLine();
        System.out.println("Nhập password:");
        String password = scanner.nextLine();
        User userLogin = new User(username, password);
        try {
            if (userManager.LoginUser(userLogin) != null) {
                User user = userManager.LoginUser(userLogin);
                if (user.getRole().equals("admin")) {
                    ProductMenu productMenu = new ProductMenu();
                    productMenu.run();
                } else if (user.getRole().equals("user")) {
                    showUserMenu();
                }

            }else {
                throw new RuntimeException("tài khoản hoặc mật khẩu k chính xác");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }


    private void doRegister() {
        userManager.add(inputUser());
    }

    private User inputUser() {
        System.out.println("mời bạn nhập username");
        String username = scanner.nextLine();
        System.out.println("mời bạn nhập password");
        String password = scanner.nextLine();
        System.out.println("mời bạn nhập id");
        String id = scanner.nextLine();
        String role = "";
        do {
            System.out.println("mời bạn nhập role(user)");
            role = scanner.nextLine();
        } while (!role.equals("admin") && !role.equals("user"));
        User user = new User(username, password, role, id);
        return user;
    }


    private void showUserMenu() {
        int choice;
        do {
            menugeneral();
            System.out.println("mời bạn nhập lụa chọn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userManager.show();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                           }

        } while (choice != 0);
    }

    private void delete() {
        System.out.println("mời bạn nhập id");
        String id = scanner.nextLine();
        userManager.delete(id);
    }

    private void update() {
        System.out.println("mời bạn nhập id");
        String id = scanner.nextLine();
        userManager.update(id, inputUser());
    }


    private static void Menu() {
        System.out.println("-------MENU ĐĂNG NHẬP------- ");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng kí");
        System.out.println("0. Thoát");
    }
}
