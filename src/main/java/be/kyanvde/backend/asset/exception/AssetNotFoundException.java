package be.kyanvde.backend.asset.exception;

public class AssetNotFoundException extends RuntimeException {

    public AssetNotFoundException(Long id) {
        super("Could not find asset with id " + id);
    }
}
