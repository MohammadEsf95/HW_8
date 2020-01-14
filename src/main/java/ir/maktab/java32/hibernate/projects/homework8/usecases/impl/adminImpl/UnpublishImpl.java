package ir.maktab.java32.hibernate.projects.homework8.usecases.impl.adminImpl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Article;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.admin.Unpublish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UnpublishImpl implements Unpublish {
    @Override
    public void unpublish(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        boolean isPublished = true;

        List<Long> articles = session.createQuery("select id from Article")
                .list();
        for (Long articleId:articles){
            if(articleId == id){
                Article article = session.load(Article.class,articleId);
                isPublished = false;
                if(isPublished){
                    article.setIsPublished("no");
                }
            }
        }
        session.getTransaction().commit();
        session.close();
    }
}
