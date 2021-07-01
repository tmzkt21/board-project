package org.bitcamp.boardproject.board.entity;

import lombok.*;
import org.bitcamp.boardproject.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    private String writer;

}
