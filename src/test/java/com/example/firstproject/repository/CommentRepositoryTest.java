package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @DisplayName("특정 게시글의 모든 댓글 조회")
    @Test
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */

        // 1. 입력 데이터 준비
        Long articleId = 4L;

        // 2. 실제 데이터
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        // 3. 예상 데이터
        Article article = new Article(articleId, "당신의 인생 영화는?", "댓글 고");

        Comment a = new Comment(1L, article, "Park", "굿 윌 헌팅");
        Comment b = new Comment(2L, article, "Kim", "아이 엠 샘");
        Comment c = new Comment(3L, article, "Choi", "쇼생크 탈출");
        List<Comment> expectedList = Arrays.asList(a, b, c);

        // 4. 비교 및 검증
        assertEquals(expectedList.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");


        /* Case 2: 1번 게시글의 모든 댓글 조회 */
        // 1. 입력 데이터 준비
        Long articleID = 1L;

        // 2. 실제 데이터
        List<Comment> commentList = commentRepository.findByArticleId(articleID);

        // 3. 예상 데이터
        Article article2 = new Article(1L, "가가가가", "1111");
        List<Comment> expected = Arrays.asList();

        // 4. 비교 및 검증
        assertEquals(expected.toString(), commentList.toString(), "1번 글은 댓글이 없음");

        /* Case 3: 9번 게시글의 모든 댓글 조회 */
        // given
        Long id = 9L;
        Article article3 = null;
        List<Comment> expect = Arrays.asList();

        // when
        List<Comment> realCommentList = commentRepository.findByArticleId(id);

        // then
        assertEquals(expect.toString(), realCommentList.toString());

        /* Case 4: 999번 게시글의 모든 댓글 조회 */
        // given
        Long id4 = 999L;
        Article article4 = null;
        List<Comment> ex4 = Arrays.asList();

        // when
        List<Comment> re4 = commentRepository.findByArticleId(id4);

        // then
        assertEquals(ex4.toString(), re4.toString());

        /* Case 5: -1번 게시글의 모든 댓글 조회 */
        // given
        Long id5 = -1L;
        Article article5 = null;
        List<Comment> ex5 = Arrays.asList();

        // when
        List<Comment> re5 = commentRepository.findByArticleId(id5);

        // then
        assertEquals(ex5.toString(), re5.toString());

    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        // given
        String nickName = "Park";
        Article a = new Article(4L, "당신의 인생 영화는?", "댓글 고");
        Article b = new Article(5L, "당신의 소울 푸드는?", "댓글 고고");
        Article c = new Article(6L, "당신의 취미는?", "댓글 고고고");
        Comment d = new Comment(1L, a, nickName, "굿 윌 헌팅");
        Comment e = new Comment(4L, b, nickName, "치킨");
        Comment f = new Comment(7L, c, nickName, "조깅");

        List<Comment> expect = Arrays.asList(d, e, f);

        // when
        List<Comment> list = commentRepository.findByNickname(nickName);

        // then
        assertEquals(expect.toString(), list.toString(), "뭐가다릉교?");

        /* Case 2: "Kim"의 모든 댓글 조회 */

        // given
        String nickname2 = "Kim";

        Article a1 = new Article(4L, "당신의 인생 영화는?", "댓글 고");
        Article b1 = new Article(5L, "당신의 소울 푸드는?", "댓글 고고");
        Article c1 = new Article(6L, "당신의 취미는?", "댓글 고고고");

        Comment d1 = new Comment(2L, a1, nickname2, "아이 엠 샘");
        Comment e1 = new Comment(5L, b1, nickname2, "샤브샤브");
        Comment f1 = new Comment(8L, c1, nickname2, "유튜브 시청");

        List<Comment> ex2 = Arrays.asList(d1, e1, f1);

        // when
        List<Comment> re2 = commentRepository.findByNickname(nickname2);

        //then
        assertEquals(ex2.toString(), re2.toString());

        /* Case 3: null의 모든 댓글 조회 */
        //given
        String nickName3 = null;
        List<Comment> ex3 = Arrays.asList();

        //when
        List<Comment> re3 = commentRepository.findByNickname(nickName3);

        //then
        assertEquals(ex3.toString(), re3.toString());


        /* Case 4: ""의 모든 댓글 조회(특정 닉네임의 입력값이 없을 때) */
        //given
        String nickName4 = "";
        List<Comment> ex4 = Arrays.asList();

        //when
        List<Comment> re4 = commentRepository.findByNickname(nickName4);

        //then
        assertEquals(ex4.toString(), re4.toString());
    }
}