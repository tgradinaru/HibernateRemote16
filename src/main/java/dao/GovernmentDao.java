package dao;

import model.Government;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class GovernmentDao extends GenericDao<Government>{

    public List<Government> findByPrimeMinisterFirstName(String firstName){
        Session session = sessionFactory.openSession();

        Query<Government> query = session.createQuery("from Government g where g.primeMinister.firstName = : parametru");
        query.setParameter("parametru", firstName);

        return query.list();
    };
}
