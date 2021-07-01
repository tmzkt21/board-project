package org.bitcamp.boardproject.todo.entity;

import lombok.*;
import org.bitcamp.boardproject.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_todo")
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;


    private String content;


    private boolean del;

    public void change(String content) {
        this.content = content;
    }

}
