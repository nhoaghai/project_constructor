package ra.business.serviceimpl;

import ra.business.config.IOFile;
import ra.business.model.Catalog;
import ra.business.service.ICatalogService;

import java.io.Serializable;
import java.util.List;

import static ra.business.config.Constants.CATALOG_PATH;

public class CatalogService implements ICatalogService, Serializable, Comparable {
    private final List<Catalog> catalogs;

    public CatalogService() {
        this.catalogs = IOFile.readFromFile(CATALOG_PATH);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogs;
    }

    @Override
    public Catalog findById(Long id) {
        return catalogs.stream().filter(ca -> ca.getCatalogId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Catalog findByName(String name) {
        Catalog catalog = catalogs.stream().filter(cat -> cat.getCatalogName().toLowerCase()
                .contains(name.toLowerCase())).findFirst().orElse(null);
        if (catalogs == null){
            System.out.println("Nhâp sai tên hoặc tên không tồn tại");
        }
        return catalog;
    }

    @Override
    public void save(Catalog catalog) {
        Catalog oldCatalog = findById(catalog.getCatalogId());
        if (oldCatalog != null) {
            //cap nhat
            catalogs.set(catalogs.indexOf(oldCatalog), catalog);
        } else {
            //them moi
            catalogs.add(catalog);
        }
        IOFile.writeToFile(CATALOG_PATH, catalogs);
    }

    @Override
    public void toggleStatusById(Long id) {
        Catalog catalog = findById(id);
        catalog.setStatus();
        IOFile.writeToFile(CATALOG_PATH, catalogs);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
