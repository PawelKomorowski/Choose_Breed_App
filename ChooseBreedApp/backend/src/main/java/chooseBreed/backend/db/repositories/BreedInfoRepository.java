package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.view.BreedsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedInfoRepository extends JpaRepository<BreedsInfo, String> {
    List<BreedsInfo> findByName(String name);
}
