package be.kyanvde.backend.asset;

import be.kyanvde.backend.asset.exception.AssetNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetController {

    private final AssetRepository repository;

    public AssetController(AssetRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/assets")
    List<Asset> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/assets")
    Asset newAsset(@RequestBody Asset newAsset) {
        return repository.save(newAsset);
    }

    // Single item

    @GetMapping("/assets/{id}")
    Asset one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException(id));

    }

    @PutMapping("/assets/{id}")
    Asset replaceAsset(@RequestBody Asset newAsset, @PathVariable Long id) {

        return repository.findById(id)
                .map(asset -> {
                    asset.setCategory(newAsset.getCategory());
                    asset.setName(newAsset.getName());
                    asset.setDescription(newAsset.getDescription());
                    asset.setImages(newAsset.getImages());
                    asset.setSchematic(newAsset.getSchematic());
                    return repository.save(asset);
                })
                .orElseGet(() -> {
                    return repository.save(newAsset);
                });
    }

    @DeleteMapping("/assets/{id}")
    void deleteAsset(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
