package model.experiment;

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
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Classroom classroom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Trainer trainer;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn
    private Team team;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private ModuleStage moduleStage;

    private LocalDate date;

    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "schedule")
    @ToString.Exclude
    private List<Attendance> attendances;
}
