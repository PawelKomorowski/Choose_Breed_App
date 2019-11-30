package chooseBreed.backend.resource.wrappers;

import chooseBreed.backend.db.model.view.BreedsInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result{
    private BreedsInfo breedsInfo;
    private float score;
    private float maxScore;
    private float percentageScore;

    public Result(BreedsInfo breedsInfo) {
        this.breedsInfo = breedsInfo;
        score = 0;
        percentageScore = 0;
    }

    public void addToScore(float val){
        score += val;
    }

    public void calculatePercentageScore(){
        if(maxScore != 0)
            percentageScore = Math.round(score/maxScore*100);
        else
            percentageScore = 0;
    }
}
