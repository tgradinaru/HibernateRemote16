import dao.DriverDao;
import dao.EmployeeDao;
import dao.GovernmentDao;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //insertEmployeeExample();
        //oneToOneInsertExample();
        //findEmployeeByFirstNameExample();
        //updateEmployeeExample();
        //deleteEmployeeExample();
        //oneToManyExample();
        //oneToManyFindExample();
        manyToManyInsertExample();
    }

    private static void manyToManyInsertExample() {
        Driver driver1 = new Driver();
        driver1.setName("Traian G.");

        Driver driver2 = new Driver();
        driver2.setName("Mos Craciun");

        Car car1 = new Car();
        car1.setMake("audi");
        car1.setModel("q8");

        Car car2= new Car();
        car2.setMake("bmw");
        car2.setModel("x3");

        Car car3 = new Car();
        car3.setMake("dacia");
        car3.setModel("logan");

        driver1.addCar(car1, car2);
        //driver2.addCar(car2); // varianta in care adugaam cate una
        driver2.addCar(car2, car3);

        car1.addDriver(driver1);
        car2.addDriver(driver1, driver2);
        car3.addDriver(driver2);

        DriverDao driverDao = new DriverDao();
        driverDao.save(driver1);
        driverDao.save(driver2);
    }

    private static void oneToManyFindExample() {
        GovernmentDao governmentDao = new GovernmentDao();
        List<Government> governmentList = governmentDao.findByPrimeMinisterFirstName("Boris");
        for (int index = 0; index < governmentList.size(); index++) {
            Government government = governmentList.get(index);
            System.out.println("Rezultat: " + index);
            System.out.println(government);
        }

        for(Government government : governmentList){
            System.out.println("Rezultat-> " + governmentList);
        }
    }

    private static void oneToManyExample() {
        Government government = new Government();
        PrimeMinister primeMinister = new PrimeMinister();
        government.setPrimeMinister(primeMinister);
        primeMinister.setGovernment(government);

        primeMinister.setFirstName("Boris");
        primeMinister.setLastName("Doe");

        government.setStartDate(LocalDate.of(2018,4,18));
        government.setEndDate(LocalDate.of(2018,12,20));

        Minister minister1 = new Minister();
        minister1.setFirstName("Traian3");
        minister1.setLastName("Gradinaru");
        minister1.setDepartment("economie");
        minister1.setGovernment(government);

        Minister minister2 = new Minister();
        minister2.setFirstName("Alexandra3");
        minister2.setLastName("Orza");
        minister2.setDepartment("aparare");
        minister2.setGovernment(government);

        Minister minister3 = new Minister();
        minister3.setFirstName("Bogdan3");
        minister3.setLastName("Judele");
        minister3.setDepartment("educatie");
        minister3.setGovernment(government);

        List<Minister> ministers = new ArrayList<>();
        ministers.add(minister1);
        ministers.add(minister2);
        ministers.add(minister3);
        government.setCabinetMinisters(ministers);

        GovernmentDao governmentDao = new GovernmentDao();
        governmentDao.save(government);

    }

    private static void deleteEmployeeExample() {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findByFirstName("Diego");
        for (Employee employee:employees){
            employeeDao.delete(employee);
        }
    }

    private static void updateEmployeeExample() {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findByFirstName("Johnny");
        for (Employee employee:employees){
            employee.setFirstName("Diego");
            employee.setLastName("Vega");
            employeeDao.update(employee);
        }
    }

    private static void findEmployeeByFirstNameExample() {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findByFirstName("Johnny");
        System.out.println(employees);
    }


    private static void insertEmployeeExample() {
        Employee employee = new Employee();
        employee.setFirstName("Traian");
        employee.setLastName("Gradinaru");
        employee.setDateOfBirth(LocalDate.of(1975, 05, 15));

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.save(employee);
    }

    private static void oneToOneInsertExample(){
        Employee employee = new Employee();
        employee.setFirstName("Johnny");
        employee.setLastName("Walker");
        employee.setDateOfBirth(LocalDate.of(1991, 02, 12));

        Address address = new Address();
        address.setCity("Iasi");
        address.setStreet("Moara de foc");
        address.setNumber(1234);
        address.setPostalCode(727072);

        employee.setAddress(address);
        address.setEmployee(employee);

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.save(employee);
    }
}