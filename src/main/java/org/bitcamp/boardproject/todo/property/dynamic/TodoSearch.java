package org.bitcamp.boardproject.todo.property.dynamic;

import org.bitcamp.boardproject.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoSearch {

    Todo doA();

    Page<Todo> listWithSearch(String keyword, Pageable pageable);
}
