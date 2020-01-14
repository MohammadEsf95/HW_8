package ir.maktab.java32.hibernate.projects.homework8.usecases.usecase;

import ir.maktab.java32.hibernate.projects.homework8.entities.Article;

public interface EditArticleText {
    void edit(Long id, String lastUpdateDate);
}
