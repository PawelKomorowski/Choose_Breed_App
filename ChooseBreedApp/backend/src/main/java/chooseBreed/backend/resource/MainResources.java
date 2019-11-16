package chooseBreed.backend.resource;

import chooseBreed.backend.db.repositories.BreedInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainResources {
    final BreedInfoRepository breedInfoRepository;

    public MainResources(BreedInfoRepository breedInfoRepository) {
        this.breedInfoRepository = breedInfoRepository;
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/main")
    public String mainPage(){
        return "mainView";
    }

    @GetMapping("/allBreeds")
    public String allBreeds(Model model){
        model.addAttribute("breedsInfos", breedInfoRepository.findAll());

        return "allBreedsView";
    }

    @GetMapping("/breed/{name}")
    public String showAllBreeds(@PathVariable String name, Model model){
        model.addAttribute("breed", breedInfoRepository.findByName(name).get(0));

        return "breedView";
    }
}
