package be.kyanvde.backend.temp;

import be.kyanvde.backend.asset.Asset;
import be.kyanvde.backend.asset.AssetCategory;
import be.kyanvde.backend.asset.AssetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AssetRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Asset(AssetCategory.TREE, "Oak tree", "The best tree in the world.", List.of("image.jpg", "image2.jpg", "image3.jpg"), "oaktree.schem")));
            log.info("Preloading " + repository.save(new Asset(AssetCategory.ROAD, "Asphalt road", "The best road in the world.", List.of("image4.jpg", "image5.jpg", "image6.jpg"), "asphaltroad.schem")));
        };
    }

}
