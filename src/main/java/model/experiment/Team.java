package model.experiment;

import lombok.Getter;
import lombok.Setter;
import model.experiment.Schedule;
import model.experiment.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Schedule> schedule;
}
