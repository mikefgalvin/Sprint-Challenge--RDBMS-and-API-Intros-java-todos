package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TodosRepository extends CrudRepository<Todos, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE todos SET completed = true, lastmodifiedby = :uname, lastmodifieddate = CURRENT_TIMESTAMP WHERE todoid = :todoid",
            nativeQuery = true)
    void updateComplete(
            String uname,
            long todoid);
}
