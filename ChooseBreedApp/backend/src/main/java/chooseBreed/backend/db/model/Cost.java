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
public class Cost {
    @Id
    @Length(max = 20)
    @Column(name = "SetName")
    private String setName;

    @Length(max = 20)
    @Column(name = "Function", nullable = false)
    private String function;

    @Column(name = "a")
    private short a;

    @Column(name = "b")
    private short b;

    @Column(name = "c")
    private short c;

    @Column(name = "d")
    private short d;
}
