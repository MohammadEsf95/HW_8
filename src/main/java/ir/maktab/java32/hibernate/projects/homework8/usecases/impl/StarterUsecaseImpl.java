package ir.maktab.java32.hibernate.projects.homework8.usecases.impl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.StarterUsecase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StarterUsecaseImpl implements StarterUsecase {
    @Override
    public void start() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Hello");

        session.getTransaction().commit();
        session.close();
    }
}
