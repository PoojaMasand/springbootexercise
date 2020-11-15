package com.example.devnews.article;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ArticleControllerTest {

    @Autowired
    ArticleController controller;
    @MockBean
    ArticleService service;

    @Test
    public void testGetById()
    {
        Article article1 = new Article("Java","This is the description","Pooja");
        Article article2 = new Article("Java123","This is the description123","Pooja123");

        Mockito.when(service.getArticleById(1L)).thenReturn(Optional.of(article1));
        Mockito.when(service.getArticleById(2L)).thenReturn(Optional.of(article2));

        Article resposeArticle1 = controller.getArticleById(1L);
        Article resposeArticle2 = controller.getArticleById(2L);

        Assertions.assertEquals(article1.getAuthorName(),resposeArticle1.getAuthorName());
        Assertions.assertEquals(article2.getAuthorName(),resposeArticle2.getAuthorName());


    }

    @Test
    public void testGetAll()
    {
        Article article1 = new Article("Java","This is the description","Pooja");
        Article article2 = new Article("Java123","This is the description123","Pooja123");
        List<Article> articleList = new ArrayList<>();
        articleList.add(article1);
        articleList.add(article2);
        Mockito.when(service.getAll()).thenReturn(articleList);

        List<Article> responseList = controller.getAll(null);
        Assertions.assertEquals(articleList.size(),responseList.size());

    }



}
