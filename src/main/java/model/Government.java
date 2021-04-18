package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Government {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer governmentId;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "government")
    private PrimeMinister primeMinister;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "government")
    private List<Minister> cabinetMinisters;
}
