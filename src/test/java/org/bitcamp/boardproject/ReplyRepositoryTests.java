package org.bitcamp.boardproject;

import lombok.extern.log4j.Log4j2;
import org.bitcamp.boardproject.board.entity.Board;
import org.bitcamp.boardproject.board.entity.Reply;
import org.bitcamp.boardproject.board.property.Replyrepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class ReplyRepositoryTests {

    @Autowired
    Replyrepository replyrepository;

    @Test
    public void testInsult() {

        IntStream.rangeClosed(1, 1000).forEach(i -> {

            long bno = (int) (Math.random() * 200) + 1;

            Reply reply = Reply.builder()
                    .replyText("so good...")
                    .board(Board.builder().bno(bno).build())
                    .build();

            replyrepository.save(reply);
        });

    }

    @Test
    public void testSelect() {

        replyrepository.findById(582L).ifPresent(todo -> {
            log.info(todo);
        });

    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0,10,Sort.by("rno").descending());
        replyrepository.findAll(pageable).forEach(todo -> {
            log.info(todo);
        });

    }

    @Test
    public void getByBoard() {
        Pageable pageable = PageRequest.of(0,10);
        Board board = Board.builder().bno(230L).build();

        replyrepository.getByBoard(board,pageable).forEach(todo-> {
            log.info(todo);
        });
    }

    @Test
    public void findReplyByReplyText() {
        replyrepository.findReplyByReplyText("so good...").forEach(todo -> {
            log.info(todo);
            // 이거 셀렉트 너무많이 한다 사용조심..
        });
    }

    @Test
    public void testDelete() {
        replyrepository.findById(2000L).ifPresent(i -> {
            replyrepository.delete(i);
        });
    }

}
