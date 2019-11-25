package chooseBreed.backend.resource.wrappers;

import chooseBreed.backend.db.model.view.BreedsInfo;
import lombok.Getter;

@Getter
public class Result {
    private BreedsInfo breedsInfo;
    private float score;
    private float maxScore;
    private int percentageScore;

    public Result(BreedsInfo breedsInfo) {
        this.breedsInfo = breedsInfo;
        score = 0;
        maxScore = 9;//TODO czy na pewno 9?
    }

    public void addToScore(float val){
        score += val;
    }

    public void calculatePercentageScore(){
        percentageScore = (int)(score/maxScore)*100;
    }
}
