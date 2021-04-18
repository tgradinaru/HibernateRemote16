package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // generare automata
    private Integer employeeId;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Address address;        //relatie one to one
}
