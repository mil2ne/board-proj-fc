package com.fastcampus.boardprojfc.dto.request;

import com.fastcampus.boardprojfc.dto.ArticleCommentDto;
import com.fastcampus.boardprojfc.dto.UserAccountDto;

public record ArticleCommentRequest(Long articleId, String content) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }
}