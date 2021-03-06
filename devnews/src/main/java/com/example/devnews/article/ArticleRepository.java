package com.example.devnews.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> getAllByTopics_Id(Long topicsId);

}

