package com.example.devnews.article;

import com.example.devnews.comment.Comment;
import com.example.devnews.topics.Topics;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="body")
    private String body;

    @Column(name="authorName")
    private String authorName;

    @OneToMany
    private List<Comment> comments;

    @ManyToMany(mappedBy = "articles")
    private List<Topics> topics;




    public Article() {
    }

    public Article(long id, String title, String body, String authorName) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;

    }

    public Article(String title, String body, String authorName) {
        this.title = title;
        this.body = body;
        this.authorName = authorName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
