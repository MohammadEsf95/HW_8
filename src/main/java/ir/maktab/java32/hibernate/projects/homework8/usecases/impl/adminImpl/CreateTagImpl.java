package ir.maktab.java32.hibernate.projects.homework8.usecases.impl.adminImpl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Tag;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.admin.CreateTag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class CreateTagImpl implements CreateTag {
    @Override
    public void createTag() {
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Tag title: ");
        String tagTitle ="#" + scanner.nextLine();
        Tag tag = new Tag();
        tag.setTitle(tagTitle);

        session.save(tag);
        session.getTransaction().commit();
        session.close();
    }
}
