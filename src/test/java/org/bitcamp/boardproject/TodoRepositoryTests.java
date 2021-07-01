package org.bitcamp.boardproject;

import lombok.extern.log4j.Log4j2;
import org.bitcamp.boardproject.todo.entity.Todo;
import org.bitcamp.boardproject.todo.property.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class TodoRepositoryTests {

    @Autowired
    TodoRepository todoRepository;

    @Test
    public void test1() {
        log.info(todoRepository.getClass().getName());
    }

    @Test
    public void testInsert() {

        IntStream.rangeClosed(1, 300).forEach(i -> {
            Todo todo = Todo.builder().content("내용..." + i).build();
            todoRepository.save(todo);
        });//loop
    }

    @Test
    public void testSelect() {

        todoRepository.findById(1L).ifPresent(todo -> log.info(todo));

    }

    @Test
    public void testPaging() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        log.info(result);

        todoRepository.findAll(pageable).getContent().forEach(todo -> log.info(todo));

    }

    @Test
    public void testChange() {
        Optional<Todo> result = todoRepository.findById(26L);
        result.ifPresent(todo -> {
            todo.change("내용수정");
            todoRepository.save(todo);
        });
    }

    @Transactional
    @Commit
    @Test
    // 299 번쨰 content  tno 299L 기준으로 바꿀거야
    public void testUpdate2() {
        todoRepository.todoUpdate(299L,"컨텐트수정");
    }

    @Test
    public void testList() {
       String keyword= "11";
       Pageable pageable = PageRequest.of(0,10);
       Page<Todo> page = todoRepository.getList(keyword,pageable);
       page.getContent().forEach(todo -> {
           log.info(todo);
       });
    }

    @Test
    public void testDao() {
        todoRepository.doA();
    }
    @Test
    public void testwithSearch() {
        String keyword = "29";
        Pageable pageable = PageRequest.of(0,10);
        Page<Todo> result = todoRepository.listWithSearch(keyword,pageable);
        result.getContent().forEach(todo-> {
            log.info(todo);
        });
    }

}
