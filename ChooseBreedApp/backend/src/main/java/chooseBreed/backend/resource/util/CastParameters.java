package chooseBreed.backend.resource.util;

import chooseBreed.backend.db.model.Cost;
import chooseBreed.backend.db.model.LiveLength;
import chooseBreed.backend.db.model.LivelihoodCost;
import chooseBreed.backend.db.model.Weight;
import chooseBreed.backend.db.model.enums.*;
import chooseBreed.backend.resource.wrappers.FuzzyParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CastParameters {
    
    public static Collection<Size> stringToSize(List<String> size){
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

    public static Collection<CleaningDifficulty> stringToCleaningDifficulty(List<String> cleaningDifficulty){
        Collection<CleaningDifficulty> collection = new ArrayList<>();
        if(cleaningDifficulty == null){
            collection.add(null);
            return collection;
        }

        for(String s : cleaningDifficulty){
            switch (s){
                case "latwo": collection.add(CleaningDifficulty.LATWO);
                    break;
                case "srednio": collection.add(CleaningDifficulty.SREDNIO);
                    break;
                case "trudno": collection.add(CleaningDifficulty.TRUDNO);
                    break;
                default: break;
            }
        }
        return collection;
    }

    public static Collection<TrainDifficulty> stringToTrainDifficulty(List<String> trainDifficulty){
        Collection<TrainDifficulty> collection = new ArrayList<>();
        if(trainDifficulty == null){
            collection.add(null);
            return collection;
        }

        for(String s : trainDifficulty){
            switch (s){
                case "latwo": collection.add(TrainDifficulty.LATWO);
                    break;
                case "srednio": collection.add(TrainDifficulty.SREDNIO);
                    break;
                case "trudno": collection.add(TrainDifficulty.TRUDNO);
                    break;
                default: break;
            }
        }
        return collection;
    }

    public static Collection<HairLength> stringToHairLength(List<String> hairLength){
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

    public static Collection<HairType> stringToHairType(List<String> hairType){
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

    public static Collection<IllnessPossibility> stringToIllnessPossibility(List<String> illnessPossibility){
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

    public static List<FuzzyParam> castCostParams(List<Cost> costs){
        List<FuzzyParam> fuzzyParams = new ArrayList<>();
        for(Cost c : costs){
            fuzzyParams.add(new FuzzyParam(c));
        }
        return fuzzyParams;
    }

    public static List<FuzzyParam> castLiveLengthParams(List<LiveLength> liveLengths){
        List<FuzzyParam> fuzzyParams = new ArrayList<>();
        for(LiveLength l : liveLengths){
            fuzzyParams.add(new FuzzyParam(l));
        }
        return fuzzyParams;
    }

    public static List<FuzzyParam> castLivelihoodCostParams(List<LivelihoodCost> livelihoodCosts){
        List<FuzzyParam> fuzzyParams = new ArrayList<>();
        for(LivelihoodCost l : livelihoodCosts){
            fuzzyParams.add(new FuzzyParam(l));
        }
        return fuzzyParams;
    }
    public static List<FuzzyParam> castWeightParams(List<Weight> weights){
        List<FuzzyParam> fuzzyParams = new ArrayList<>();
        for(Weight w : weights){
            fuzzyParams.add(new FuzzyParam(w));
        }
        return fuzzyParams;
    }

}
