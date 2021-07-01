package org.bitcamp.boardproject.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class TodoDTO {
    private Long tno;
    private String content;
    private boolean del;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
