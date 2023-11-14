package ra.business.ultil;
import ra.business.model.Catalog;

import static ra.business.config.Constants.NULL_ERROR_MESSAGE;
import static ra.presentation.CatalogManagement.catalogService;

public class Validate {
    public static void checkDuplicate(String input){
        catalogService.findByName(input);
    }
}
