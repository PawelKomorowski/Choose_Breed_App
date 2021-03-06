package chooseBreed.backend.db.model;

import chooseBreed.backend.db.model.enums.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Breed {
    @Id
    @Column(name = "Name", length = 60)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Size", nullable = false, length = 20)
    private Size size;

    @Column(name = "Weight", nullable = false)
    private short weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "IllnessPossibility", nullable = false, length = 20)
    private IllnessPossibility illnessPossibility;

    @Enumerated(EnumType.STRING)
    @Column(name = "CleaningDifficulty", nullable = false, length = 20)
    private CleaningDifficulty cleaningDifficulty;

    @Enumerated(EnumType.STRING)
    @Column(name = "TrainDifficulty", nullable = false, length = 20)
    private TrainDifficulty trainDifficulty;

    @Enumerated(EnumType.STRING)
    @Column(name = "HairLength", nullable = false, length = 20)
    private HairLength hairLength;

    @Enumerated(EnumType.STRING)
    @Column(name = "HairType", nullable = false, length = 20)
    private HairType hairType;

    @Column(name = "LiveLength", nullable = false)
    private short liveLength;

    @Column(name = "Cost", nullable = false)
    private short cost;

    @Column(name = "LivelihoodCost", nullable = false)
    private short livelihoodCost;

    @Column(name = "Description", nullable = false)
    @Type(type = "text")
    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private BreedGroup breedGroup;

    @OneToMany(mappedBy = "breed")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Photo> photos = new ArrayList<>();

    public String urlEncode(){
        try {
            return URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error occurred during encoding breed: " + name);
            return "error";
        }
    }
}
