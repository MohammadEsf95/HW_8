package ir.maktab.java32.hibernate.projects.homework8.usecases.impl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.ChangePassword;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.Scanner;

public class ChangePasswordImpl implements ChangePassword {
    @Override
    public void change(String username) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Enter your new password: ");
        String newPass = scanner.nextLine();
        Query query = session.createQuery("update User set password = :password where username = : username");
        query.setParameter("username",username);
        query.setParameter("password", newPass);
        query.executeUpdate();


        session.getTransaction().commit();
        session.close();
    }
}
