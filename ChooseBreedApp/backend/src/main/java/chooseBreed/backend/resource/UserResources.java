package chooseBreed.backend.resource;

import chooseBreed.backend.db.model.enums.*;
import chooseBreed.backend.db.model.view.BreedsInfo;
import chooseBreed.backend.db.repositories.*;
import chooseBreed.backend.resource.util.AssessResult;
import chooseBreed.backend.resource.wrappers.FuzzyParam;
import chooseBreed.backend.resource.wrappers.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;


import static chooseBreed.backend.resource.util.CastParameters.*;


@Controller
public class UserResources {
    final BreedInfoRepository breedInfoRepository;
    final CostRepository costRepository;
    final LiveLengthRepository liveLengthRepository;
    final LivelihoodCostRepository livelihoodCostRepository;
    final WeightRepository weightRepository;

    public UserResources(BreedInfoRepository breedInfoRepository, CostRepository costRepository, LiveLengthRepository liveLengthRepository, LivelihoodCostRepository livelihoodCostRepository, WeightRepository weightRepository) {
        this.breedInfoRepository = breedInfoRepository;
        this.costRepository = costRepository;
        this.liveLengthRepository = liveLengthRepository;
        this.livelihoodCostRepository = livelihoodCostRepository;
        this.weightRepository = weightRepository;
    }

    @GetMapping("/all")
    public String allBreeds(Model model){
        model.addAttribute("pageTitle", "Wszystkie rasy");
        model.addAttribute("breedsInfos", breedInfoRepository.findAll());

        return "all";
    }

    @GetMapping("/breed/{name}")
    public String showBreed(@PathVariable String name, Model model){
        String nameDecoded;
        try {
            nameDecoded = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            nameDecoded = name;
        }

        model.addAttribute("pageTitle", nameDecoded);
        model.addAttribute("breed", breedInfoRepository.findByName("Hawańczyk").get(0));

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

        Collection<Size> sizeParam = stringToSize(size);
        Collection<IllnessPossibility> illnessParam = stringToIllnessPossibility(illnesses);
        Collection<CleaningDifficulty> cleaningParam = stringToCleaningDifficulty(cleaning_difficulty);
        Collection<TrainDifficulty> trainParam = stringToTrainDifficulty(training_difficulty);
        Collection<HairLength> hairLengthParam = stringToHairLength(hair_length);
        Collection<HairType> hairTypeParam = stringToHairType(hair_type);

        List<FuzzyParam> fuzzyLiveLength = castLiveLengthParams(liveLengthRepository.findAll());
        List<FuzzyParam> fuzzyCost = castCostParams(costRepository.findAll());
        List<FuzzyParam> fuzzyLivelihoodCost = castLivelihoodCostParams(livelihoodCostRepository.findAll());
        List<FuzzyParam> fuzzyWeight = castWeightParams(weightRepository.findAll());

        List<Short> costValues = getExtremeValuesForParams(fuzzyCost, cost);
        List<Short> liveLengthValues = getExtremeValuesForParams(fuzzyLiveLength, live_length);
        List<Short> livelihoodCostValues = getExtremeValuesForParams(fuzzyLivelihoodCost, livelihood_cost);

        List<BreedsInfo> breedsInfos = breedInfoRepository.findByParams(sizeParam, illnessParam, cleaningParam,
                trainParam, hairLengthParam, hairTypeParam, costValues.get(0), costValues.get(1),
                liveLengthValues.get(0), liveLengthValues.get(1), livelihoodCostValues.get(0), livelihoodCostValues.get(1));

        List<Result> results = new AssessResult().assess(breedsInfos,  size, illnessParam, live_length, cost,
                livelihood_cost, cleaningParam, trainParam, hairLengthParam, hairTypeParam,
                fuzzyLiveLength, fuzzyCost, fuzzyLivelihoodCost, fuzzyWeight);

        model.addAttribute("results", results);
        model.addAttribute("pageTitle", "Wyniki wyszukiwania");

        return "result";
    }
}
