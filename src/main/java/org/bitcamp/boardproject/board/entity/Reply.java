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
@Table(name = "tbl_reply")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String replyText;

    @ManyToOne
    Board board;


}
