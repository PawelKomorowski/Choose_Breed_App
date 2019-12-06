package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.enums.*;
import chooseBreed.backend.db.model.view.BreedsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BreedInfoRepository extends JpaRepository<BreedsInfo, String> {
    List<BreedsInfo> findByName(String name);

    @Query(value = "SELECT b FROM BreedsInfo b " +
            "WHERE b.size IN (:size) " +
            "OR b.cleaningDifficulty IN (:cleaningDifficulty) " +
            "OR b.illnessPossibility IN (:illnessPossibility) " +
            "OR b.trainDifficulty IN (:trainingDifficulty) " +
            "OR b.hairLength IN (:hairLength) " +
            "OR b.hairType IN (:hairType) " +
            "OR (b.cost > :costMin AND b.cost < :costMax) " +
            "OR (b.liveLength > :liveLengthMin AND b.liveLength < :liveLengthMax) " +
            "OR (b.livelihoodCost > :livelihoodCostMin AND b.livelihoodCost < :livelihoodCostMax)")
    List<BreedsInfo> findByParams(@Param("size") Collection<Size> size,
                                  @Param("illnessPossibility") Collection<IllnessPossibility> illnessPossibility,
                                  @Param("cleaningDifficulty") Collection<CleaningDifficulty> cleaningDifficulty,
                                  @Param("trainingDifficulty") Collection<TrainDifficulty> trainingDifficulty,
                                  @Param("hairLength") Collection<HairLength> hairLength,
                                  @Param("hairType") Collection<HairType> hairType,
                                  @Param("costMin") short costMin,
                                  @Param("costMax") short costMax,
                                  @Param("liveLengthMin") short liveLengthMin,
                                  @Param("liveLengthMax") short liveLengthMax,
                                  @Param("livelihoodCostMin") short livelihoodCostMin,
                                  @Param("livelihoodCostMax") short livelihoodCostMax);
}