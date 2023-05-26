package com.fastcampus.boardprojfc.repository;

import com.fastcampus.boardprojfc.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
