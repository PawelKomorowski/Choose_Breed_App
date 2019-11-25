package chooseBreed.backend.db.repositories;

import chooseBreed.backend.db.model.LiveLength;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveLengthRepository extends JpaRepository<LiveLength, Integer> {
}
