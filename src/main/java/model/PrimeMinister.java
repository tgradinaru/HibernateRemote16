package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class PrimeMinister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer primeMinisterId;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @ToString.Exclude
    private Government government;
}
