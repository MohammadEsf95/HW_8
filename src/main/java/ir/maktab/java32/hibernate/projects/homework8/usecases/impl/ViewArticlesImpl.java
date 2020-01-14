package ir.maktab.java32.hibernate.projects.homework8.usecases.impl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Article;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.ViewArticles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class ViewArticlesImpl implements ViewArticles {

    @Override
    public void showAll(Long id) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List showArticles = session.createQuery("from Article where User .id =: id")
                .setParameter("id",id)
                .list();
        if (showArticles.size() > 0) {
            System.out.println("\n" +
                    " Article\n==========================================");
            for (Object article : showArticles) {
                System.out.println(article.toString());
            }
            System.out.println("==========================================");
        } else {
            System.out.println("Article not found");
        }



        session.getTransaction().commit();
        session.close();
    }
}
