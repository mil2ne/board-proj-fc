package com.fastcampus.boardprojfc.repository;

import com.fastcampus.boardprojfc.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
