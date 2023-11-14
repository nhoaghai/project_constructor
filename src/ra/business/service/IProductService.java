package ra.business.service;

import ra.business.model.Product;

public interface IProductService extends IGeneric<Product, Long> {
    Product findByName(String name);

    Long getNewId();
}
