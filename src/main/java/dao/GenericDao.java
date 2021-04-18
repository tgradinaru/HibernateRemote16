package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GenericDao<X> {
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    //era "private" dar il facem "protected" ca sa fie vazut de clasele copii


    public void save(X someObject) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction(); // deschide tranzactia

        session.save(someObject);

        transaction.commit();       // inchide tranzactia
        session.close();
    }

    public void update(X someObject){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction(); // deschide tranzactia

        session.update(someObject);

        transaction.commit();       // inchide tranzactia
        session.close();
    }

    public void delete(X someObject){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction(); // deschide tranzactia

        session.delete(someObject);

        transaction.commit();       // inchide tranzactia
        session.close();
    }

    //public List<X> findByFieldName
}
