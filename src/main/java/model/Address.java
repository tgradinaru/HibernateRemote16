package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
// @Table(name = "addresses") //recomandat sa nu se foloseasca
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId ;

    private String street;
    private Integer number;
    private Integer postalCode;
    private String city;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL) //spun catre ce camp se va face relatia
    //cascadeaza si crearea angajatului daca nu exista
    @ToString.Exclude           // in tostring-ul lui Address exclud employee - sa evit eroare "stackoverflow"
    private Employee employee;
}
