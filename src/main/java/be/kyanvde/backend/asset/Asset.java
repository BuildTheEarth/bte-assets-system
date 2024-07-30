package be.kyanvde.backend.asset;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asset {

    private @Id
    @GeneratedValue Long id;

    private AssetCategory category;

    private String name;
    private String description;

    @ElementCollection
    @CollectionTable(name = "asset_images", joinColumns = @JoinColumn(name = "asset_id"))
    @Column(name = "image")
    private List<String> images;

    private String schematic;

    public Asset(AssetCategory category, String name, String description, List<String> images, String schematic) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.images = images;
        this.schematic = schematic;
    }

    public Asset() {}

    // Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssetCategory getCategory() {
        return category;
    }

    public void setCategory(AssetCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getSchematic() {
        return schematic;
    }

    public void setSchematic(String schematic) {
        this.schematic = schematic;
    }
}
