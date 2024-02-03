package ra.business.service;

import ra.business.model.Catalog;
import ra.business.model.Product;

public interface IProductService extends IGeneric<Product, String> {
    Product findByName(String name);
    Product findByCatalog(Catalog catalog);
}
