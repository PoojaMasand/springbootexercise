package com.example.devnews.comment;

import com.example.devnews.article.Article;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private long id;

        @Column(name="body")
        private String body;

        @Column(name="authorName")
        private String authorName;

        @ManyToOne
        private Article article;

    public Comment() {
    }

    public Comment(long id, String body, String authorName, Article article) {
        this.id = id;
        this.body = body;
        this.authorName = authorName;
        this.article = article;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
