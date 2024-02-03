package ra.presentation;

import ra.business.ultil.InputMethods;

import java.util.Scanner;

public class BasicManagement {
    static Scanner scanner = new Scanner(System.in);
    public static String userName;
    public static String password;

    public static void main(String[] args) {
        while (true) {
            System.out.println("=======Welcome=======");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.println("======================");

            byte choice = InputMethods.getByte();
            switch (choice) {
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
}
