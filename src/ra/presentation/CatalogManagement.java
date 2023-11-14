package ra.presentation;

import ra.business.model.Catalog;
import ra.business.serviceimpl.CatalogService;
import ra.business.ultil.InputMethods;

import java.time.LocalDateTime;

public class CatalogManagement {
    public static final CatalogService catalogService = new CatalogService();

    public static void run() {
        while (true) {
            System.out.println("=======Catalog Management ========");
            System.out.println("1. Hiển thị danh mục");
            System.out.println("2. Tạo mới danh mục");
            System.out.println("3. Tìm kiếm danh mục theo tên");
            System.out.println("4. Chỉnh sửa thông tin danh mục");
            System.out.println("5. Ẩn/hiện danh mục theo mã danh mục");
            System.out.println("6. Quay lại");
            System.out.println("==================================");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    displayCatalog();
                    break;
                case 2:
                    addNewCatalog();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    editCatalog();
                    break;
                case 5:
                    toggleStatusById();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhập không đúng lựa chọn");
                    System.out.println("Vui lòng nhập lại");
            }
        }
    }
    //Hiển thị danh sách danh mục
    public static void displayCatalog() {
        for (Catalog cat : catalogService.findAll()) {
            if (cat != null) {
                if (cat.isStatus()) {
                    System.out.println(cat);
                }
            }else{
                System.out.println("Danh mục chống");
            }
        }
        //catalogService.findAll();
    }
    //Thêm mới danh mục
    public static void addNewCatalog() {
        System.out.println("Nhập id Catalog mới: ");
        Long newId = InputMethods.getLong();

        if (catalogService.findById(newId) != null){
            System.out.println("Id đã tồn tại");
        }
        else{
            Catalog catalog = new Catalog();
            catalog.setCatalogId(newId);
            System.out.println("Nhập tên Catalog mới: ");
            catalog.setCatalogName(InputMethods.getString());
            System.out.println("Nhập mô tả mới: ");
            catalog.setDescription(InputMethods.getString());
            catalog.setCreated_at(LocalDateTime.now());
            catalogService.save(catalog);
        }
    }
    //Tìm kiếm danh mục theo tên
    public static void searchByName(){
        System.out.println("Nhập tên danh mục cần tìm kiếm");
        String name = InputMethods.getString();
        System.out.println(catalogService.findByName(name));
    }
    public static void editCatalog(){
        System.out.println("Nhập vào id danh mục muốn sửa");
        Long newId = InputMethods.getLong();
        Catalog catalog= catalogService.findById(newId);
        if (catalog == null){
            System.out.println("Không tìm thấy");
        }else {
            System.out.println("Nhập vào tên catalog mới");
            catalog.setCatalogName(InputMethods.getString());
            System.out.println("Nhập vào mô tả mới: ");
            catalog.setDescription(InputMethods.getString());
            catalogService.save(catalog);
        }
    }
    public static void toggleStatusById(){
        displayCatalog();
        System.out.println("Nhập id danh mục cần thay đổi");
        Long id = InputMethods.getLong();
        catalogService.toggleStatusById(id);
    }
}