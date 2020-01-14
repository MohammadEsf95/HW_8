package ir.maktab.java32.hibernate.projects.homework8.usecases.impl.adminImpl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Category;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.admin.CreateCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class CreateCategoryImpl implements CreateCategory {
    @Override
    public void createCategory() {
        Scanner  scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Enter category title: ");
        String catTitle = scanner.nextLine();
        System.out.println("Enter category description: ");
        String catDes = scanner.nextLine();
        Category category = new Category(catTitle,catDes);

        session.save(category);
        session.getTransaction().commit();
        session.close();
    }
}
