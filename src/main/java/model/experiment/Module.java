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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String moduleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    private List<ModuleStage> moduleStages;
}
