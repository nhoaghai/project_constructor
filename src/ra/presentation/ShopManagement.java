package ra.presentation;

import ra.business.ultil.InputMethods;

import java.util.Objects;
import java.util.Scanner;

public class ShopManagement {
    static Scanner scanner = new Scanner(System.in);
    public static String userName;
    public static String password;
    public static CatalogManagement catalogManagement = new CatalogManagement();
    public static ProductManagement productManagement = new ProductManagement();
    public static void main(String[] args) {
        //Login
        System.out.print("Nhập tên tài khoản: ");
        userName = InputMethods.getString();
        System.out.print("Nhập mật khẩu: ");
        password = InputMethods.getString();
        if (Objects.equals(userName, "admin") && Objects.equals(password, "admin")){
            while (true){
                System.out.println("=======Welcome=======");
                System.out.println("1. Quản lý danh mục");
                System.out.println("2. Quản lý sản phẩm");
                System.out.println("3. Thoát");
                System.out.println("======================");

                byte choice = InputMethods.getByte();
                switch (choice){
                    case 1:
                        CatalogManagement.run();
                        break;
                    case 2:
                        ProductManagement.run();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Nhập không đúng lựa chọn");
                        System.out.println("Vui lòng nhập lại");
                }
            }
        }
        else {
            System.out.println("Sai tài khoản hoặc mật khẩu");
        }
    }
}
