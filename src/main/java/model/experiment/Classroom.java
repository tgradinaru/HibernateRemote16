package model.experiment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String className;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classroom")
    private List<Schedule> schedules;
}
