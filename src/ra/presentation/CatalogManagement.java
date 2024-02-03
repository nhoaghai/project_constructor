package ra.presentation;

import ra.business.model.Catalog;
import ra.business.model.Product;
import ra.business.serviceimpl.CatalogService;
import ra.business.ultil.InputMethods;

import java.time.LocalDateTime;

public class CatalogManagement {
    public static final CatalogService catalogService = new CatalogService();

    public static void run() {
        while (true) {
            System.out.println("=======Catalog Management ========");
            System.out.println("1. Tạo mới danh mục");
            System.out.println("2. Hiển thị danh mục");
            System.out.println("3. Chỉnh sửa tên danh mục");
            System.out.println("4. Xóa danh mục theo id");
            System.out.println("0. Quay lại");
            System.out.println("==================================");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addNewCatalog();
                    break;
                case 2:
                    displayCatalog();
                    break;
                case 3:
                    editCatalogName();
                    break;
                case 4:
                    deleteById();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Nhập không đúng lựa chọn");
                    System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static void displayCatalog() {
        for (Catalog catalog : catalogService.findAll()) {
            if (catalog != null) {
                System.out.println(catalog);
            } else {
                System.out.println("Danh sách sản phẩm chống");
            }
        }
    }

    //Thêm mới danh mục
    public static void addNewCatalog() {
        while (true) {
            System.out.println("Nhập id Catalog mới: ");
            Integer newId = InputMethods.getInteger();

            if (catalogService.findById(newId) != null) {
                System.out.println("Id đã tồn tại");
            } else {
                Catalog catalog = new Catalog();
                catalog.setCatalogId(newId);
                System.out.println("Nhập tên Catalog mới: ");
                catalog.setCatalogName(InputMethods.getString());
                catalogService.save(catalog);
            }
            System.out.println("Bạn có muốn thêm tiếp danh mục: ");
            System.out.println("1. Có");
            System.out.println("2. Thoát");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    return;
                default:
                    System.err.println("Nhập không đúng lựa chọn");
                    System.out.println("Vui lòng nhập lại");
            }
        }
    }

    public static void editCatalogName() {
        System.out.println("Nhập vào id danh mục muốn sửa");
        Integer newId = InputMethods.getInteger();
        Catalog catalog = catalogService.findById(newId);
        if (catalog == null) {
            System.out.println("Không tìm thấy");
        } else {
            System.out.println("Nhập vào tên catalog mới");
            catalog.setCatalogName(InputMethods.getString());
            catalogService.save(catalog);
        }
    }

    public static void deleteById() {
        System.out.println("Nhập id sản phẩm muốn xóa");
        catalogService.deleteById(InputMethods.getInteger());
    }
}