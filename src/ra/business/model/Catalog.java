package ra.business.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Catalog implements Serializable {
    private Long catalogId;
    private String catalogName;
    private String description;
    private LocalDateTime created_at;
    private boolean status = true;

    public Catalog() {
    }

    public Catalog(Long catalogId, String catalogName, String description, boolean status, LocalDateTime created_at) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.created_at = created_at;
        this.status = status;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(){
        this.status = !status;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", status=" + status +
                '}';
    }
}
