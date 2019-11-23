package chooseBreed.backend.resource;

import chooseBreed.backend.db.model.enums.*;
import chooseBreed.backend.db.model.view.BreedsInfo;
import chooseBreed.backend.db.repositories.BreedInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static chooseBreed.backend.resource.util.Parameters.*;


@Controller
public class UserResources {
    final BreedInfoRepository breedInfoRepository;

    public UserResources(BreedInfoRepository breedInfoRepository) {
        this.breedInfoRepository = breedInfoRepository;
    }

    @GetMapping("/all")
    public String allBreeds(Model model){
        model.addAttribute("pageTitle", "Wszystkie rasy");
        model.addAttribute("breedsInfos", breedInfoRepository.findAll());

        return "all";
    }

    @GetMapping("/breed/{name}")
    public String showAllBreeds(@PathVariable String name, Model model){
        String url;
        try {
            url = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            url = name;
        }

        model.addAttribute("pageTitle", url);
        model.addAttribute("breed", breedInfoRepository.findByName(url).get(0));

        return "breed";
    }

    @GetMapping("/")
    public String search(Model model){
        model.addAttribute("pageTitle", "Wyszukiwanie");

        return "search";
    }

    @GetMapping("/result")
    public String result(Model model, @RequestParam(required = false) List<String> size,
                         @RequestParam(required = false) List<String> illnesses, @RequestParam(required = false) List<String> live_length,
                         @RequestParam(required = false) List<String> cost, @RequestParam(required = false) List<String> livelihood_cost,
                         @RequestParam(required = false) List<String> cleaning_difficulty, @RequestParam(required = false) List<String> training_difficulty,
                         @RequestParam(required = false) List<String> hair_length, @RequestParam(required = false) List<String> hair_type){

        List<BreedsInfo> breedsInfos = breedInfoRepository.findByParams(stringToSize(size), stringToIllnessPossibility(illnesses),
                stringToCleaningDifficulty(cleaning_difficulty), stringToTrainDifficulty(training_difficulty),
                stringToHairLength(hair_length), stringToHairType(hair_type));

        for(BreedsInfo b : breedsInfos)
            System.out.println(b.toString());

        model.addAttribute("results", breedsInfos);
        model.addAttribute("pageTitle", "Wyniki wyszukiwania");

        return "result";
    }
}
