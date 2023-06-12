package com.fastcampus.boardprojfc.repository.querydsl;

import java.util.List;

public interface ArticleRepositoryCustom {
    List<String> findAllDistinctHashtags();
}
