package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

public interface TodosService
{
    void markComplete(long todoid);

//    Todos markComplete(
//            long todoid,
//            Todos todo
//    );

    Todos save(long userid, String description);

}

