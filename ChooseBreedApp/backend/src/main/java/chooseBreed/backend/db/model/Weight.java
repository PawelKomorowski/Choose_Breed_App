package chooseBreed.backend.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Weight {
    @Id
    @Length(max = 20)
    @Column(name = "SetName")
    private String setName;

    @Length(max = 20)
    @Column(name = "Function", nullable = false)
    private String function;

    @Column(name = "a")
    private float a;

    @Column(name = "b")
    private float b;

    @Column(name = "c")
    private float c;

    @Column(name = "d")
    private float d;
}
