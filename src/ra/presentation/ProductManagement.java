package ra.presentation;

import ra.business.model.Catalog;
import ra.business.model.Product;
import ra.business.serviceimpl.CatalogService;
import ra.business.serviceimpl.ProductService;
import ra.business.ultil.InputMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductManagement {
    public static final ProductService productService = new ProductService();
    public static final CatalogService catalogService = new CatalogService();

    public static void run() {
        while (true) {
            System.out.println("======= Product Management ========");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Hiển thị danh sách sản phẩm theo giá giảm dần");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sản phẩm theo tên ");
            System.out.println("5. Chỉnh sửa sản phẩm theo mã ");
            System.out.println("0. Quay lại");
            System.out.println("==================================");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    break;
                case 4:
                    deleteById();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    editProduct();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Nhập không đúng lựa chọn");
                    System.out.println("Vui lòng nhập lại");
            }
        }
    }

    //Hiển thị danh sách danh mục
    public static void displayProduct() {
        for (Product pro : productService.findAll()) {
            if (pro != null) {
                if (pro.isStatus()) {
                    System.out.println(pro);
                }
            }else {
                System.out.println("Danh sách sản phẩm chống");
            }
        }
    }

    //Thêm mới danh mục
    public static void addNewProduct() {
        while (true){
            Product product = new Product();
            CatalogManagement.displayCatalog();
            System.out.println("Chọn danh mục sản phẩm: ");
            product.setCatalog(catalogService.findById(InputMethods.getInteger()));
            System.out.println("Nhập id sản phẩm mới: ");
            String newId = InputMethods.getString();

            if (productService.findById(newId) != null){
                System.out.println("Id đã tồn tại");
            }
            else{
                product.setProductId(newId);
                System.out.println("Nhập tên sản phẩm mới: ");
                product.setProductName(InputMethods.getString());
                System.out.println("Nhập mô tả sản phẩm mới: ");
                product.setDescription(InputMethods.getString());
                System.out.println("Nhập đơn giá: ");
                product.setUnitPrice(InputMethods.getDouble());
                System.out.println("Nhập số lượng còn trong kho: ");
                product.setStock(InputMethods.getInteger());;
                productService.save(product);
            }
            System.out.println("Bạn có muốn thêm tiếp sản phẩm: ");
            System.out.println("1. Có");
            System.out.println("2. Thoát");
            byte choice = InputMethods.getByte();
            switch (choice){
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

    //Tìm kiếm danh mục theo tên
    public static void searchByName() {
        System.out.println("Nhập tên sản phẩm cần tìm kiếm");
        String name = InputMethods.getString();
        System.out.println(productService.findByName(name));
    }

    public static void editProduct() {
        System.out.println("Nhập vào id product muốn sửa");
        String newId = InputMethods.getString();
        Product product = productService.findById(newId);
        if (product == null) {
            System.out.println("Không tìm thấy");
        } else {
            System.out.println("Nhập vào tên product mới");
            product.setProductName(InputMethods.getString());
            System.out.println("Nhập vào mô tả mới: ");
            product.setDescription(InputMethods.getString());
            System.out.println("Nhập đơn giá mới: ");
            product.setUnitPrice(InputMethods.getByte());
            System.out.println("Nhập số lượng còn trong kho: ");
            product.setStock(InputMethods.getByte());
            productService.save(product);
        }
    }
    public static void deleteById(){
        productService.deleteById(InputMethods.getString());
        System.out.println("Delete successfully");
        displayProduct();
    }
}
