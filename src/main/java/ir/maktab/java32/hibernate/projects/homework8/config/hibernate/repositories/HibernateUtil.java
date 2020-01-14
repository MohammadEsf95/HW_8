package ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static SessionFactory sessionFactory2;
    private static SessionFactory sessionFactory3;
    static {
        sessionFactory = new Configuration().configure("hibernate.db1.cfg.xml").buildSessionFactory();
        sessionFactory2 = new Configuration().configure("hibernate.db2.cfg.xml").buildSessionFactory();
        sessionFactory3 = new Configuration().configure("hibernate.h2.cfg.xml").buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){return sessionFactory;}
    public static SessionFactory getSessionFactory2(){return sessionFactory2;}
    public static SessionFactory getSessionFactory3(){return sessionFactory3;}
}
