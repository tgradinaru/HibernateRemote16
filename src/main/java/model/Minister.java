package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Minister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ministerId;

    private String firstName;
    private String lastName;
    private String department;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn
    private Government government;
}
