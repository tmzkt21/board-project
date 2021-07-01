package org.bitcamp.boardproject.todo.property;

import org.bitcamp.boardproject.todo.entity.Todo;
import org.bitcamp.boardproject.todo.property.dynamic.TodoSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<Todo,Long> , TodoSearch {



    @Query("select t from Todo t where t.content like concat('%',:keyword,'%') order by t.tno desc")
    //SELECT 컬럼명 FROM 테이블명 WHERE 컬럼명=값 ORDER BY 컬럼명 ASC or DESC;
    Page<Todo> getList(String keyword, Pageable pageable);


    @Modifying
    @Query("update Todo set content=:content where tno=:tno")
    // UPDATE 테이블명 SET 컬럼명 = 변경할 값 WHERE 컬럼명=값;
    void todoUpdate(Long tno ,String content);

}
