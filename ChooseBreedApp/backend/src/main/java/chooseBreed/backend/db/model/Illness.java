package chooseBreed.backend.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Illness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name", unique = true, nullable = false, length = 100)
    private String name;

    @ManyToMany(mappedBy = "illnesses")
    private List<Breed> breeds = new ArrayList<>();
}
