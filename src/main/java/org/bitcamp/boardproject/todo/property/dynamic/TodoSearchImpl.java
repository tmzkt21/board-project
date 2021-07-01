package org.bitcamp.boardproject.todo.property.dynamic;

import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.bitcamp.boardproject.todo.entity.QTodo;
import org.bitcamp.boardproject.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Todo doA() {
        log.warn("서치로그테스트");

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = from(todo);
        // query
        query.where(todo.tno.gt(180));
        // 180 보다 큰 녀석들은 몇명인지 카운트
        query.orderBy(todo.tno.desc());
        // tno 기준 내림차순

        query.offset(0);
        // 0페이지
        query.limit(10);
        // 한페이당 10개씩

        List<Todo> count = query.fetch();
        long result = query.fetchCount();

        log.warn("==============");
        log.info("COUNT: "+count);
        log.warn(result);

        return null;
    }

    @Override
    public Page<Todo> listWithSearch(String keyword, Pageable pageable) {
        QTodo todo = QTodo.todo;
        JPQLQuery<Todo> query = from(todo);
        // 키워드가 널이아니고 공백도 없으면 컨텐트에 담는다..
        if (keyword != null &&  keyword.trim().length() != 0) {
            query.where(todo.content.contains(keyword));
        }
        // 0 보다 큰 tno
        query.where(todo.tno.gt(0L));
        // tno 기준 내림차순
        query.orderBy(todo.tno.desc());

        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());

        List<Todo> list = query.fetch();
        long count = query.fetchCount();

        return new PageImpl<>(list,pageable,count);
    }
}
