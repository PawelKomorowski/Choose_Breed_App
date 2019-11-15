package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.view.BreedsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedInfoRepository extends JpaRepository<BreedsInfo, String> {
}
