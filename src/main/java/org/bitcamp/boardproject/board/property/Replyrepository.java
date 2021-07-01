package org.bitcamp.boardproject.board.property;

import org.bitcamp.boardproject.board.entity.Board;
import org.bitcamp.boardproject.board.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Replyrepository extends JpaRepository<Reply,Long> {

    Page<Board> getByBoard(Board board, Pageable pageable);

    List<Reply> findReplyByReplyText(String replyText);
    //댓글로 검색
}
