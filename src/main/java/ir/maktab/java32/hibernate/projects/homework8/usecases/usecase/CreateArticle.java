package ir.maktab.java32.hibernate.projects.homework8.usecases.usecase;

import ir.maktab.java32.hibernate.projects.homework8.entities.Article;
import ir.maktab.java32.hibernate.projects.homework8.entities.User;

public interface CreateArticle {
    void create(User user,String currentDate);
}
