package ra.business.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Catalog implements Serializable {
    private Integer catalogId;
    private String catalogName;

    public Catalog() {
    }

    public Catalog(Integer catalogId, String catalogName) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                '}';
    }
}
