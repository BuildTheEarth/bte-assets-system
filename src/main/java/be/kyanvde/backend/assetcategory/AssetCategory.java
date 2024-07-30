package be.kyanvde.backend.assetcategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AssetCategory {

    private @Id
    @GeneratedValue Long id;

    private String name;
    private String icon; // tabler.io icon

    public AssetCategory(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public AssetCategory() {

    }

    // Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
