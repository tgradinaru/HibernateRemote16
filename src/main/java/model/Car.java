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
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;

    private String make;
    private String model;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "car_driver",                     //aici se creaza un al 3-lea tabel in care se fac legaturile
            joinColumns = @JoinColumn(name = "carId"),      // coloana din acest tabel
            inverseJoinColumns = @JoinColumn(name= "driverId"))     //coloana din celalalt tabel unde e legatura
    @ToString.Exclude
    private List<Driver> drivers;

    public void addDriver(Driver... driversArray) {
        if (drivers == null) {                 // identic ca in clasa Driver, aceeasi logica
            drivers = new ArrayList<>();
        }

        for(Driver driverElement: driversArray){
            drivers.add(driverElement);
        }
    }
}
