package ir.maktab.java32.hibernate.projects.homework8.usecases.impl;

import ir.maktab.java32.hibernate.projects.homework8.config.hibernate.repositories.HibernateUtil;
import ir.maktab.java32.hibernate.projects.homework8.entities.Article;
import ir.maktab.java32.hibernate.projects.homework8.entities.Category;
import ir.maktab.java32.hibernate.projects.homework8.entities.User;
import ir.maktab.java32.hibernate.projects.homework8.usecases.usecase.CreateArticle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class CreateAritcleImpl implements CreateArticle {
    @Override
    public void create(User user, String currentDate) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        boolean categoryExist = false;
        Long categoryId = null;

        System.out.println("category id: ");

        while (!categoryExist){
            categoryId = Long.parseLong(scanner.nextLine());
            List categoryIds = session.createQuery("select id from Category")
                    .list();
            for (Object obj: categoryIds){
                if(obj==categoryId){
                    categoryExist = true;
                    break;
                }
            }
            if (!categoryExist){
                System.out.println("category not found");
            }
        }



        System.out.println("title: ");
        String title = scanner.nextLine();
        System.out.println("brief: ");
        String brief = scanner.nextLine();
        System.out.println("content: ");
        String content = scanner.nextLine();
//        System.out.println("create date: ");
//        String createDate = currentDate;
        String isPublished = "no";
        String lastUpdateDate = currentDate;

        List<Category> categoryList = session.createQuery("from Category where id=: id")
                .setParameter("id",categoryId)
                .list();
        Category category = categoryList.get(0);
        Article article = new Article(user,category,title,brief,content,currentDate,isPublished);


        session.save(article);
        session.getTransaction().commit();
        session.close();
    }
}
