package ra.business.service;

import ra.business.model.Catalog;

public interface ICatalogService extends IGeneric<Catalog, Long> {
    Catalog findByName(String name);
}
