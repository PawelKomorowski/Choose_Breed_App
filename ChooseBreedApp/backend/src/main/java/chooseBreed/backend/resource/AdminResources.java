package chooseBreed.backend.resource;

import chooseBreed.backend.db.repositories.*;
import org.springframework.stereotype.Controller;

@Controller
public class AdminResources {
    final BreedRepository breedRepository;
    final PhotoRepository photoRepository;

    public AdminResources(BreedRepository breedRepository, PhotoRepository photoRepository) {
        this.breedRepository = breedRepository;
        this.photoRepository = photoRepository;
    }


}
