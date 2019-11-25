package chooseBreed.backend.resource.util;

import chooseBreed.backend.db.model.enums.*;
import chooseBreed.backend.db.model.view.BreedsInfo;
import chooseBreed.backend.resource.wrappers.FuzzyParam;
import chooseBreed.backend.resource.wrappers.Result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssessResult {
    private final int enumScore = 1;

    public List<Result> assess(List<BreedsInfo> breedsInfos, List<String> size, Collection<IllnessPossibility> illnessPossibility,
                                   List<String> live_length, List<String> cost, List<String> livelihood_cost,
                                   Collection<CleaningDifficulty> cleaningDifficulty, Collection<TrainDifficulty> trainingDifficulty,
                                   Collection<HairLength> hairLength, Collection<HairType> hairType,
                                   List<FuzzyParam> liveLengthParams, List<FuzzyParam> costParams,
                                   List<FuzzyParam> livelihoodCostParams, List<FuzzyParam> weightParams){
        if(breedsInfos.size() == 0) {
            return new ArrayList<>();
        }
        IndicatorFunctions indicatorFunctions = new IndicatorFunctions(costParams, liveLengthParams, livelihoodCostParams, weightParams);
        List<Result> results = castBreedToResult(breedsInfos);
        //TODO assess if breed enums values are in lists
        //TODO assess how much number values fit fuzzy values
        for(Result r : results){
            BreedsInfo b = r.getBreedsInfo();

//            checkEnumParam(r, size.contains(b.getSize()));
            checkEnumParam(r, illnessPossibility.contains(b.getIllnessPossibility()));
            checkEnumParam(r, cleaningDifficulty.contains(b.getCleaningDifficulty()));
            checkEnumParam(r, trainingDifficulty.contains(b.getTrainDifficulty()));
            checkEnumParam(r, hairLength.contains(b.getHairLength()));
            checkEnumParam(r, hairType.contains(b.getHairType()));
            r.addToScore(indicatorFunctions.checkCost(b, cost));
            r.addToScore(indicatorFunctions.checkLiveLength(b, live_length));
            r.addToScore(indicatorFunctions.checkLivelihoodCost(b, livelihood_cost));
            r.addToScore(indicatorFunctions.checkWeight(b, size));
        }
        return results;
    }

    private void checkEnumParam(Result r, boolean contains) {
        if (contains) {
            r.addToScore(enumScore);
        }
    }

    private List<Result> castBreedToResult(List<BreedsInfo> breedsInfos){
        List<Result> results = new ArrayList<>();
        for(BreedsInfo breedsInfo : breedsInfos){
            results.add(new Result(breedsInfo));
        }
        return results;
    }



}
