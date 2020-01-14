package ir.maktab.java32.hibernate.projects.homework8.usecases.impl.adminImpl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Article;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.admin.ShowAllArticles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ShowAllArticlesImpl implements ShowAllArticles {
    @Override
    public void showAllArticles() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Article> articleList = session.createQuery("from Article ")
                .list();
        for(Article article: articleList){
            if(article.getIsPublished().equalsIgnoreCase("yes")){
                System.out.println(article);
            }
        }

        session.getTransaction().commit();
        session.close();
    }
}
