package com.example.devnews.topics;

import com.example.devnews.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TopicsRepository extends JpaRepository<Topics,Long> {
    List<Topics> getAllByArticles_Id(Long articleId);
}
