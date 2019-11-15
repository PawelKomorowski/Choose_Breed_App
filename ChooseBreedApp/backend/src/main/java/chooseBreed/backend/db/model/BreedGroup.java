package chooseBreed.backend.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BreedGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name", unique = true, nullable = false, length = 30)
    private String name;
    @OneToMany(mappedBy = "breedGroup")
    private List<Breed> breeds = new ArrayList<>();;
}
