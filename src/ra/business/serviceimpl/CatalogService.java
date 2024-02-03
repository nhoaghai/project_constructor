package ra.business.serviceimpl;

import ra.business.config.IOFile;
import ra.business.model.Catalog;
import ra.business.service.ICatalogService;

import java.io.Serializable;
import java.util.List;

import static ra.business.config.Constants.CATALOG_PATH;

public class CatalogService implements ICatalogService, Serializable {
    private final List<Catalog> catalogs;
    public static final ProductService productService =new ProductService();

    public CatalogService() {
        this.catalogs = IOFile.readFromFile(CATALOG_PATH);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogs;
    }

    @Override
    public Catalog findById(Integer id) {
        return catalogs.stream().filter(catalog -> catalog.getCatalogId().equals(id)).findFirst().orElse(null);
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
    public void deleteById(Integer id) {

        if (productService.findByCatalog(findById(id)) != null){
            System.err.println("Catalog tồn tại product ko thể xóa");
        }
        Catalog catalog = findById(id);
        if (catalog != null){
            catalogs.remove(catalog);
        }else {
            System.err.println("Could not find id");
        }
    }
}
