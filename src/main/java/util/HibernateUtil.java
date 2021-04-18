package util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory instance = null;

    public static SessionFactory getSessionFactory(){

        if (instance == null) {
            // trebuie sa initializez
            instantiateSessionFactory();
        }
        return instance;
    }

    private static void instantiateSessionFactory() { //metoda care initializeaza o apelam in getSessionFactory()
        /*START BOILER PLATE CODE */
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_remote16?useSSL=false");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "password");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update"); // daca de la o rulare la alta
                // facem modificari(ex adaug o coloana) atunci se va face update automat
                // "create" - reface baza de date dar imi pierd datele anterioare - > drop all

        configuration.addAnnotatedClass(Employee.class); //pentru fiecare clasa din model avem nevoie de o linie asa
        // vrem ca aceasta clasa sa fie administrata de Hibernate
        configuration.addAnnotatedClass(Address.class);

        configuration.addAnnotatedClass(Government.class);
        configuration.addAnnotatedClass(Minister.class);
        configuration.addAnnotatedClass(PrimeMinister.class);
        configuration.addAnnotatedClass(Driver.class);
        configuration.addAnnotatedClass(Car.class);

        configuration.setProperties(settings);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        instance = configuration.buildSessionFactory(serviceRegistry);
        /*END BOILER PLATE CODE*/
    }

}
