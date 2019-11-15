package chooseBreed.backend.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "file", unique = true, nullable = false, length = 255)
    private String file;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Breed breed;

}
