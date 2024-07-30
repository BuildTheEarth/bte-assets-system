package be.kyanvde.backend.assetusage.exception;

public class AssetUsageNotFoundException extends RuntimeException {

    public AssetUsageNotFoundException(Long id) {
        super("Could not find asset usage with id " + id);
    }
}
