package ra.business.serviceimpl;

import ra.business.config.IOFile;
import ra.business.model.Catalog;
import ra.business.model.Product;
import ra.business.service.IProductService;

import static ra.business.config.Constants.PRODUCT_PATH;
import java.util.List;

public class ProductService implements IProductService {
    List<Product> products;
    public ProductService(){
        this.products = IOFile.readFromFile(PRODUCT_PATH);
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(pro -> pro.getProductId().equals(id))
                .findFirst().orElse(null);
    }
    @Override
    public Product findByName(String name) {
        Product product = products.stream().filter(pro -> pro.getProductName().equalsIgnoreCase(name)).findFirst().orElse(null);
        if (product == null){
            System.out.println("Nhập sai tên hoặc tên không tồn tại");
        }
        return product;
    }
    @Override
    public void save(Product product) {
        Product oldProduct = findById(product.getProductId());
        if (oldProduct != null){
            //cap nhat
            products.set(products.indexOf(oldProduct),product);
        }else{
            //them moi
            products.add(product);
        }
        IOFile.writeToFile(PRODUCT_PATH,products);
    }

    @Override
    public void toggleStatusById(Long id) {
        Product product = findById(id);
        product.setStatus();
        IOFile.writeToFile(PRODUCT_PATH, products);
    }

    @Override
    public Long getNewId() {
        return products.stream().map(Product::getProductId)
                .max(Long::compare).orElse(0L)+1;
    }
}
