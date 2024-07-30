package be.kyanvde.backend.assetusage;

import be.kyanvde.backend.assetusage.exception.AssetUsageNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetUsageController {

    private final AssetUsageRepository repository;

    public AssetUsageController(AssetUsageRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/assetusages")
    List<AssetUsage> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/assetusages")
    AssetUsage newAssetUsage(@RequestBody AssetUsage newAssetUsage) {
        return repository.save(newAssetUsage);
    }

    // Single item

    @GetMapping("/assetusages/{id}")
    AssetUsage one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AssetUsageNotFoundException(id));
    }
}
