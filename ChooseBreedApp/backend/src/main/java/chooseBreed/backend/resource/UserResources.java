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

    private Collection<Size> stringToSize(List<String> size){
        Collection<Size> collection = new ArrayList<>();
        if(size == null){
            collection.add(null);
            return collection;
        }

        for(String s : size){
            switch (s){
                case "maly": collection.add(Size.MALY);
                    break;
                case "sredni": collection.add(Size.SREDNI);
                    break;
                case "duzy": collection.add(Size.DUZY);
                    break;
                case "olbrzym": collection.add(Size.OLBRZYM);
                    break;
                default: break;
            }
        }
        return collection;
    }

    private Collection<CleaningDifficulty> stringToCleaningDifficulty(List<String> cleaningDifficulty){
        Collection<CleaningDifficulty> collection = new ArrayList<>();
        if(cleaningDifficulty == null){
            collection.add(null);
            return collection;
        }

        for(String s : cleaningDifficulty){
            switch (s){
                case "latwo": collection.add(CleaningDifficulty.LATWO);
                    break;
                case "sredno": collection.add(CleaningDifficulty.SREDNIO);
                    break;
                case "trudno": collection.add(CleaningDifficulty.TRUDNO);
                    break;
                default: break;
            }
        }
        return collection;
    }

    private Collection<TrainDifficulty> stringToTrainDifficulty(List<String> trainDifficulty){
        Collection<TrainDifficulty> collection = new ArrayList<>();
        if(trainDifficulty == null){
            collection.add(null);
            return collection;
        }

        for(String s : trainDifficulty){
            switch (s){
                case "latwo": collection.add(TrainDifficulty.LATWO);
                    break;
                case "sredno": collection.add(TrainDifficulty.SREDNIO);
                    break;
                case "trudno": collection.add(TrainDifficulty.TRUDNO);
                    break;
                default: break;
            }
        }
        return collection;
    }

    private Collection<HairLength> stringToHairLength(List<String> hairLength){
        Collection<HairLength> collection = new ArrayList<>();
        if(hairLength == null){
            collection.add(null);
            return collection;
        }

        for(String s : hairLength){
            switch (s){
                case "krotka": collection.add(HairLength.KROTKA);
                    break;
                case "srednia": collection.add(HairLength.SREDNIA);
                    break;
                case "dluga": collection.add(HairLength.DLUGA);
                    break;
                default: break;
            }
        }
        return collection;
    }

    private Collection<HairType> stringToHairType(List<String> hairType){
        Collection<HairType> collection = new ArrayList<>();
        if(hairType == null){
            collection.add(null);
            return collection;
        }

        for(String s : hairType){
            switch (s){
                case "puchata": collection.add(HairType.PUCHATA);
                    break;
                case "szorstka": collection.add(HairType.SZORSTKA);
                    break;
                case "gladka": collection.add(HairType.GLADKA);
                    break;
                default: break;
            }
        }
        return collection;
    }

    private Collection<IllnessPossibility> stringToIllnessPossibility(List<String> illnessPossibility){
        Collection<IllnessPossibility> collection = new ArrayList<>();
        if(illnessPossibility == null){
            collection.add(null);
            return collection;
        }

        for(String s : illnessPossibility){
            switch (s){
                case "mala": collection.add(IllnessPossibility.MALA);
                    break;
                case "srednia": collection.add(IllnessPossibility.SREDNIA);
                    break;
                case "duza": collection.add(IllnessPossibility.DUZA);
                    break;
                default: break;
            }
        }
        return collection;
    }
}
