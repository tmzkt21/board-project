package org.bitcamp.boardproject.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bitcamp.boardproject.todo.property.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

}
