package be.kyanvde.backend.assetcategory;

import be.kyanvde.backend.asset.exception.AssetNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetCategoryController {

    private final AssetCategoryRepository repository;

    public AssetCategoryController(AssetCategoryRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @CrossOrigin
    @GetMapping("/assets/categories")
    List<AssetCategory> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/assets/categories")
    AssetCategory newAssetCategory(@RequestBody AssetCategory newAsset) {
        return repository.save(newAsset);
    }

    // Single item

    @GetMapping("/assets/categories/{id}")
    AssetCategory one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException(id));

    }

    @PutMapping("/assets/categories/{id}")
    AssetCategory replaceAssetCategory(@RequestBody AssetCategory newAssetCategory, @PathVariable Long id) {

        return repository.findById(id)
                .map(assetCategory -> {
                    assetCategory.setName(newAssetCategory.getName());
                    assetCategory.setIcon(newAssetCategory.getIcon());
                    return repository.save(assetCategory);
                })
                .orElseGet(() -> {
                    return repository.save(newAssetCategory);
                });
    }

    @DeleteMapping("/assets/categories/{id}")
    void deleteAsset(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
