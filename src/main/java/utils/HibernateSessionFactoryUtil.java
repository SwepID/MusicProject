package utils;

import entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Album.class);
                configuration.addAnnotatedClass(Artist.class);
                configuration.addAnnotatedClass(Country.class);
                configuration.addAnnotatedClass(Genre.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Song.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception! " + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
