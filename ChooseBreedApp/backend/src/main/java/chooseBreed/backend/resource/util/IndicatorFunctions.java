package chooseBreed.backend.resource.util;

import chooseBreed.backend.db.model.view.BreedsInfo;
import chooseBreed.backend.resource.wrappers.FuzzyParam;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class IndicatorFunctions {
    private List<FuzzyParam> costParams;
    private List<FuzzyParam> liveLengthParams;
    private List<FuzzyParam> livelihoodCostParams;
    private List<FuzzyParam> weightParams;


    //TODO na podstawie parametrów z wyszukiwarki określić jaka będzie funkcja i wtedy policzyć

    // Sprawdza wynik dla kosztu
    public float checkCost(BreedsInfo breedsInfo, List<String> costs){
        if(costs == null || costs.size() == 0)
            return 0;
        float maxScore = 0;
        float tempScore = 0;
        FuzzyParam chosenParam;
        //Dla każdego z zaznaczonych kosztów w wyszukiwarce
        for(String s : costs){
            //Pobiera odpowiadający zbiór
            chosenParam = getCostParam(s);
            //Jeśli zbiór istnieje to oblicz odpowiednią wartość funkcji i podstaw pod teymczasową wartość
            if(chosenParam != null){
                switch (chosenParam.getFunction()){
                    case "L": tempScore = functionL(chosenParam.getA(), chosenParam.getB(), breedsInfo.getCost());
                    break;
                    case "lambda": tempScore = functionLambda(chosenParam.getA(), chosenParam.getB(), chosenParam.getC(), breedsInfo.getCost());
                    break;
                    case "gamma": tempScore = functionGamma(chosenParam.getA(), chosenParam.getB(), breedsInfo.getCost());
                    break;
                    default: tempScore = 0;
                }
            }
            if(tempScore > maxScore){
                maxScore = tempScore;
            }
        }
        return maxScore;
    }

    // Sprawdza wynik dla kosztu
    public float checkLiveLength(BreedsInfo breedsInfo, List<String> liveLengths){
        if(liveLengths == null || liveLengths.size() == 0)
            return 0;
        float maxScore = 0;
        float tempScore = 0;
        FuzzyParam chosenParam;
        //Dla każdego z zaznaczonych kosztów w wyszukiwarce
        for(String s : liveLengths){
            //Pobiera odpowiadający zbiór
            chosenParam = getLiveLengthParam(s);
            //Jeśli zbiór istnieje to oblicz odpowiednią wartość funkcji i podstaw pod teymczasową wartość
            if(chosenParam != null){
                switch (chosenParam.getFunction()){
                    case "L": tempScore = functionL(chosenParam.getA(), chosenParam.getB(), breedsInfo.getLiveLength());
                        break;
                    case "lambda": tempScore = functionLambda(chosenParam.getA(), chosenParam.getB(), chosenParam.getC(), breedsInfo.getLiveLength());
                        break;
                    case "gamma": tempScore = functionGamma(chosenParam.getA(), chosenParam.getB(), breedsInfo.getLiveLength());
                        break;
                    default: tempScore = 0;
                }
            }
            if(tempScore > maxScore){
                maxScore = tempScore;
            }
        }
        return maxScore;
    }

    // Sprawdza wynik dla kosztu
    public float checkLivelihoodCost(BreedsInfo breedsInfo, List<String> livelihoodCosts){
        if(livelihoodCosts == null || livelihoodCosts.size() == 0)
            return 0;
        float maxScore = 0;
        float tempScore = 0;
        FuzzyParam chosenParam;
        //Dla każdego z zaznaczonych kosztów w wyszukiwarce
        for(String s : livelihoodCosts){
            //Pobiera odpowiadający zbiór
            chosenParam = getLivelihoodCostParam(s);
            //Jeśli zbiór istnieje to oblicz odpowiednią wartość funkcji i podstaw pod teymczasową wartość
            if(chosenParam != null){
                switch (chosenParam.getFunction()){
                    case "L": tempScore = functionL(chosenParam.getA(), chosenParam.getB(), breedsInfo.getLivelihoodCost());
                        break;
                    case "lambda": tempScore = functionLambda(chosenParam.getA(), chosenParam.getB(), chosenParam.getC(), breedsInfo.getLivelihoodCost());
                        break;
                    case "gamma": tempScore = functionGamma(chosenParam.getA(), chosenParam.getB(), breedsInfo.getLivelihoodCost());
                        break;
                    default: tempScore = 0;
                }
            }
            if(tempScore > maxScore){
                maxScore = tempScore;
            }
        }
        return maxScore;
    }

    // Sprawdza wynik dla kosztu
    public float checkWeight(BreedsInfo breedsInfo, List<String> weights){
        if(weights == null || weights.size() == 0)
            return 0;
        float maxScore = 0;
        float tempScore = 0;
        FuzzyParam chosenParam;
        //Dla każdego z zaznaczonych kosztów w wyszukiwarce
        for(String s : weights){
            //Pobiera odpowiadający zbiór
            chosenParam = getWeightParam(s);
            //Jeśli zbiór istnieje to oblicz odpowiednią wartość funkcji i podstaw pod teymczasową wartość
            if(chosenParam != null){
                switch (chosenParam.getFunction()){
                    case "L": tempScore = functionL(chosenParam.getA(), chosenParam.getB(), breedsInfo.getWeight());
                        break;
                    case "lambda": tempScore = functionLambda(chosenParam.getA(), chosenParam.getB(), chosenParam.getC(), breedsInfo.getWeight());
                        break;
                    case "gamma": tempScore = functionGamma(chosenParam.getA(), chosenParam.getB(), breedsInfo.getWeight());
                        break;
                    default: tempScore = 0;
                }
            }
            if(tempScore > maxScore){
                maxScore = tempScore;
            }
        }
        return maxScore;
    }

    private FuzzyParam getCostParam(String cost){
        for(FuzzyParam f : costParams){
            if(f.getSetName().equals(cost)){
                return f;
            }
        }
        return null;
    }

    private FuzzyParam getLiveLengthParam(String liveLength){
        for(FuzzyParam f : liveLengthParams){
            if(f.getSetName().equals(liveLength)){
                return f;
            }
        }
        return null;
    }

    private FuzzyParam getLivelihoodCostParam(String livelihoodCost){
        for(FuzzyParam f : livelihoodCostParams){
            if(f.getSetName().equals(livelihoodCost)){
                return f;
            }
        }
        return null;
    }
    private FuzzyParam getWeightParam(String weight){
        for(FuzzyParam f : weightParams){
            if(f.getSetName().equals(weight)){
                return f;
            }
        }
        return null;
    }

    private float functionL(float a, float b, float x){
        if(x <= a)
            return 1;
        else if(a < x && x <= b)
            return (b-x)/(b-a);
        else
            return 0;
    }

    private float functionLambda(float a, float b, float c, float x){
        if(x <= a || x >= c)
            return 0;
        else if(a < x && x <= b)
            return (x-a)/(b-a);
        else
            return (c-x)/(c-b);
    }

    private float functionGamma(float a, float b, float x){
        if(x <= a)
            return 0;
        else if(a < x && x <= b)
            return (x-a)/(b-a);
        else
            return 1;
    }
}
