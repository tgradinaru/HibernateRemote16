package model.experiment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class ModuleStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn
    private Module module;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn
    private Schedule schedule;
}
