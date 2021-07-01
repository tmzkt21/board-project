package org.bitcamp.boardproject;

import lombok.extern.log4j.Log4j2;
import org.bitcamp.boardproject.board.entity.Board;
import org.bitcamp.boardproject.board.property.Boardrepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class BoardRepositoryTests {

    @Autowired
    Boardrepository boardRepository;
    @Test
    public void test() {
        log.info("테스트 정상 작동");
    }

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1,1000).forEach(i->{
            Board board = Board.builder()
                    .title("게시글제목" +i)
                    .content("게시글내용" +i)
                    .writer("게시글작성자" +i)
                    .build();
            boardRepository.save(board);
        });
    }

    @Test
    public void findBoardByContent() {
        boardRepository.findByContent("게시글내용4").forEach(todo -> {
            log.info(todo);
        });
    }
}
