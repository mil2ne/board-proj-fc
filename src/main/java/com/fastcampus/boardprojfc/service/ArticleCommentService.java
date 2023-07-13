package com.fastcampus.boardprojfc.service;

import com.fastcampus.boardprojfc.domain.Article;
import com.fastcampus.boardprojfc.domain.ArticleComment;
import com.fastcampus.boardprojfc.domain.UserAccount;
import com.fastcampus.boardprojfc.dto.ArticleCommentDto;
import com.fastcampus.boardprojfc.repository.ArticleCommentRepository;
import com.fastcampus.boardprojfc.repository.ArticleRepository;
import com.fastcampus.boardprojfc.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;
    private final ArticleRepository articleRepository;
    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return articleCommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(ArticleCommentDto::from)
                .toList();
    }

    public void saveArticleComment(ArticleCommentDto dto) {
        try {
            Article article = articleRepository.getReferenceById(dto.articleId());
            UserAccount userAccount = userAccountRepository.getReferenceById(dto.userAccountDto().userId());
            ArticleComment articleComment = dto.toEntity(article, userAccount);

            if (dto.parentCommentId() != null) {
                ArticleComment parentComment = articleCommentRepository.getReferenceById(dto.parentCommentId());
                parentComment.addChildComment(articleComment);
            } else {
                articleCommentRepository.save(articleComment);
            }

        } catch (EntityNotFoundException e) {
            log.warn("댓글 저장 실패. 댓글 작성에 필요한 정보를 찾을 수 없습니다 - {}", e.getLocalizedMessage());
        }
    }



    public void deleteArticleComment(Long articleCommentId, String userId) {
        articleCommentRepository.deleteByIdAndUserAccount_UserId(articleCommentId, userId);
    }
}
