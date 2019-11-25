package chooseBreed.backend.resource.wrappers;

import chooseBreed.backend.db.model.Cost;
import chooseBreed.backend.db.model.LiveLength;
import chooseBreed.backend.db.model.LivelihoodCost;
import chooseBreed.backend.db.model.Weight;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuzzyParam {
    private String setName;
    private String function;
    private float a;
    private float b;
    private float c;
    private float d;

    public FuzzyParam(Weight weight){
        this.setName = weight.getSetName();
        this.function = weight.getFunction();
        this.a = weight.getA();
        this.b = weight.getB();
        this.c = weight.getC();
        this.d = weight.getD();
    }

    public FuzzyParam(Cost cost){
        this.setName = cost.getSetName();
        this.function = cost.getFunction();
        this.a = cost.getA();
        this.b = cost.getB();
        this.c = cost.getC();
        this.d = cost.getD();
    }

    public FuzzyParam(LiveLength liveLength){
        this.setName = liveLength.getSetName();
        this.function = liveLength.getFunction();
        this.a = liveLength.getA();
        this.b = liveLength.getB();
        this.c = liveLength.getC();
        this.d = liveLength.getD();
    }

    public FuzzyParam(LivelihoodCost livelihoodCost){
        this.setName = livelihoodCost.getSetName();
        this.function = livelihoodCost.getFunction();
        this.a = livelihoodCost.getA();
        this.b = livelihoodCost.getB();
        this.c = livelihoodCost.getC();
        this.d = livelihoodCost.getD();
    }
}
