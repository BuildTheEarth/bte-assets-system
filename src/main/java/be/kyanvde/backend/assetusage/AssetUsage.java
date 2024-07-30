package be.kyanvde.backend.assetusage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AssetUsage {

    @Id
    @GeneratedValue private Long id;

    private Long assetId;

    private int x;
    private int z;


    public AssetUsage() {
    }

    public AssetUsage(Long assetId, int x, int z) {
        this.assetId = assetId;
        this.x = x;
        this.z = z;
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
