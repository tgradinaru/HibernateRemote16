package model.experiment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.experiment.Schedule;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
    private List<Schedule> schedules;
}
