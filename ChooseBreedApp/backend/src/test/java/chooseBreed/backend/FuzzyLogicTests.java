package chooseBreed.backend;

import chooseBreed.backend.db.model.*;
import chooseBreed.backend.db.model.enums.*;
import chooseBreed.backend.db.model.view.BreedsInfo;
import chooseBreed.backend.resource.util.IndicatorFunctions;
import chooseBreed.backend.resource.wrappers.FuzzyParam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FuzzyLogicTests {

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnCorrectFunctionValue(){
		BreedsInfo breed = createBreed();

		List<FuzzyParam> costParams = new ArrayList<>();
		List<FuzzyParam> liveLengthParams = new ArrayList<>();
		List<FuzzyParam> livelihoodCostParams = new ArrayList<>();
		List<FuzzyParam> weightParams = new ArrayList<>();
		costParams.add(new FuzzyParam(createCostParam()));
		liveLengthParams.add(new FuzzyParam(createLiveLengthParam()));
		livelihoodCostParams.add(new FuzzyParam(createLivelihoodCostParam()));
		weightParams.add(new FuzzyParam(createWeightParam()));

		List<String> costs = new ArrayList<>();
		List<String> weights = new ArrayList<>();
		List<String> liveLengths = new ArrayList<>();
		List<String> livelihoodCosts = new ArrayList<>();
		costs.add("maly");
		weights.add("sredni");
		liveLengths.add("maly");
		livelihoodCosts.add("duzy");

		IndicatorFunctions indicatorFunctions = new IndicatorFunctions(costParams, liveLengthParams, livelihoodCostParams, weightParams);

		assertEquals(Math.round(indicatorFunctions.checkCost(breed, costs)*10), 5);
		assertEquals(Math.round(indicatorFunctions.checkWeight(breed, weights)*1000), 714);
		assertEquals(Math.round(indicatorFunctions.checkLivelihoodCost(breed, livelihoodCosts)*1000), 667);
		assertEquals(Math.round(indicatorFunctions.checkLiveLength(breed, liveLengths)), 0);
	}

	BreedsInfo createBreed(){
		BreedsInfo breed = new BreedsInfo();
		breed.setSize(Size.SREDNI);
		breed.setWeight((short) 20);
		breed.setIllnessPossibility(IllnessPossibility.MALA);
		breed.setTrainDifficulty(TrainDifficulty.LATWO);
		breed.setLivelihoodCost((short) 300);
		breed.setCost((short) 2000);
		breed.setLiveLength((short) 14);
		breed.setHairType(HairType.PUCHATA);
		breed.setHairLength(HairLength.SREDNIA);
		breed.setCleaningDifficulty(CleaningDifficulty.SREDNIO);
		return breed;
	}

	Cost createCostParam(){
		Cost cost = new Cost();
		cost.setSetName("maly");
		cost.setFunction("L");
		cost.setA((short) 1000);
		cost.setB((short) 3000);
		cost.setC((short) 0);
		cost.setD((short) 0);
		return cost;
	}

	Weight createWeightParam(){
		Weight weight = new Weight();
		weight.setSetName("sredni");
		weight.setFunction("lambda");
		weight.setA((short) 15);
		weight.setB((short) 22);
		weight.setC((short) 30);
		weight.setD((short) 0);
		return weight;
	}

	LivelihoodCost createLivelihoodCostParam(){
		LivelihoodCost livelihoodCost = new LivelihoodCost();
		livelihoodCost.setSetName("duzy");
		livelihoodCost.setFunction("gamma");
		livelihoodCost.setA((short) 200);
		livelihoodCost.setB((short) 350);
		livelihoodCost.setC((short) 0);
		livelihoodCost.setD((short) 0);
		return livelihoodCost;
	}

	LiveLength createLiveLengthParam(){
		LiveLength cliveLengthst = new LiveLength();
		cliveLengthst.setSetName("malaaa");
		cliveLengthst.setFunction("L");
		cliveLengthst.setA((short) 1000);
		cliveLengthst.setB((short) 3000);
		cliveLengthst.setC((short) 0);
		cliveLengthst.setD((short) 0);
		return cliveLengthst;
	}
}
