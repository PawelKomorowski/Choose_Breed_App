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
public class LiveLength {
    @Id
    @Length(max = 20)
    @Column(name = "SetName")
    private String setName;

    @Column(name = "a", precision = 2, scale = 2)
    private BigDecimal a;

    @Column(name = "b", precision = 2, scale = 2)
    private BigDecimal b;

    @Column(name = "c", precision = 2, scale = 2)
    private BigDecimal c;

    @Column(name = "d", precision = 2, scale = 2)
    private BigDecimal d;
}
