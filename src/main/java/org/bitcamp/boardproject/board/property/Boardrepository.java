package org.bitcamp.boardproject.board.property;

import org.bitcamp.boardproject.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Boardrepository extends JpaRepository<Board,Long> {

    List<Board> findByContent(String content);

}
