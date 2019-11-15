package chooseBreed.backend.db.model.view;

import chooseBreed.backend.db.model.enums.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "breeds_info")
//@Subselect(
//        "SELECT b.name, g.name as group_name, b.size, b.weight, i.illnesses_count, b.cleaning_difficulty, b.train_difficulty, b.hair_length, b.hair_type, b.live_length, b.cost, b.livelihood_cost, b.description\n" +
//                "FROM breed b \n" +
//                "INNER JOIN breed_group g ON b.breed_group_id = g.id\n" +
//                "INNER JOIN photo p ON b.name = p.breed_name\n" +
//                "INNER JOIN (SELECT breeds_name, COUNT(*) as illnesses_count FROM breed_illnesses GROUP BY breeds_name) i ON i.breeds_name = b.name"
//)
//@Synchronize({"breed", "breed_group", "photo", "breed_illnesses"})
@Immutable
@Getter
@NoArgsConstructor
public class BreedsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name", length = 60)
    private String name;

    @Column(name = "GroupName", length = 30)
    private String groupName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Size", nullable = false, length = 20)
    private Size size;

    @Column(name = "Weight", nullable = false)
    private short weight;

    @Column(name = "IllnessesCount")
    private short illnessesCount;

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
}