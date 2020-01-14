package ir.maktab.java32.hibernate.projects.homework8.usecases.impl.adminImpl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Article;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.admin.DeleteArticle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class DeleteArticleImpl implements DeleteArticle {
    @Override
    public void deleteArticle(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Long> articles = session.createQuery("select id from Article ")
                .list();
        for (Long articleId: articles){
            if(articleId == id){
                Article article = session.load(Article.class,articleId);
                session.remove(article);
                System.out.println("Article has removed successfully");
            }else {
                System.out.println("Article not found");
            }
        }

        session.getTransaction().commit();
        session.close();
    }
}
