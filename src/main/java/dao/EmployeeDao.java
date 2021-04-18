package dao;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class EmployeeDao extends GenericDao<Employee>{
    public List<Employee> findByFirstName(String firstName){
        Session session = sessionFactory.openSession();

        Query<Employee> query = session.createQuery("from Employee e where firstName = :someValue");
        query.setParameter("someValue", firstName);

        return query.list();
    }
}
