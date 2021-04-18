package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverId;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "drivers")
    private List<Car> cars; // in mod implicit ia valoarea "null"

    public void addCar(Car... carsArray) {        //varargs pt mai multe masini
        if (cars == null) {                 // doar daca lista este goala o instantiem, altfel nu
            cars = new ArrayList<>();
        }

        for(Car carElement: carsArray){
            cars.add(carElement);
        }
    }
}
