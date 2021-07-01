package org.bitcamp.boardproject.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bitcamp.boardproject.todo.dto.TodoDTO;
import org.bitcamp.boardproject.todo.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/")
    public void register(@RequestBody TodoDTO todoDTO) {
        log.info("register........." + todoDTO);
    }
}
