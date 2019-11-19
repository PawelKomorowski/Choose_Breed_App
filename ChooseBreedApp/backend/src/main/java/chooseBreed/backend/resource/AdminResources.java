package chooseBreed.backend.resource;

import chooseBreed.backend.db.repositories.*;
import org.springframework.stereotype.Controller;

@Controller
public class AdminResources {
    final BreedRepository breedRepository;
    final IllnessRepository illnessRepository;
    final PhotoRepository photoRepository;

    public AdminResources(BreedRepository breedRepository, IllnessRepository illnessRepository, PhotoRepository photoRepository) {
        this.breedRepository = breedRepository;
        this.illnessRepository = illnessRepository;
        this.photoRepository = photoRepository;
    }


}
