package com.example.devnews.article;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleRestTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    ArticleService service;

    @Test
    public void testGetAllReturnEmptyArray()
    {
        Article[] response = testRestTemplate.getForObject("/articles",Article[].class);
        Assertions.assertEquals(0,response.length);
    }

    @Test
    public void testCreate()
    {
        Article article1 = new Article(1,"Java","My Book2","Pooja");
        Article response = testRestTemplate.postForObject("/articles",article1,Article.class);

        Assertions.assertEquals(response.getAuthorName(),article1.getAuthorName());

        testRestTemplate.delete("/articles" + response.getId());
    }
    @Test
    public void testUpdate()
    {
        Article article1 = new Article(1,"Java","My Book2","Pooja");
        Article original = service.create(article1);
        Article updated = new Article(original.getId(),"Java","My Book2","Masand");
        HttpEntity<Article> requestBody = new HttpEntity<>(updated);
        HttpEntity<Article> response = testRestTemplate.exchange("/articles", HttpMethod.PUT, requestBody,Article.class);
        Article updatedArticle = response.getBody();

        Assertions.assertEquals(updatedArticle.getAuthorName(),updated.getAuthorName());

    }
}
