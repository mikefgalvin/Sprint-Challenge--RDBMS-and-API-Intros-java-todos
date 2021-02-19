package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The entry point for client to access user, todos combinations
 */
@RestController
@RequestMapping("/todos")
public class TodosController
{
    /**
     * Using the Todos service to process user, todos combinations data
     */
    @Autowired
    TodosService todosService;

    /**
     * Given the todo id, mark the task as complete
     * <br>Example: <a href="http://localhost:2019/todos/todo/7">http://localhost:2019/todos/todo/7</a>
     *
     * @param todoid The todo to be marked complete
     * @return Status of OK
     */
    @PatchMapping(value = "/todo/{todoid}")
    public ResponseEntity<?> completeTodo(
        @PathVariable
            long todoid)
    {
        todosService.markComplete(todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PutMapping(value = "/todo/{todoid}", consumes = {"application/json"})
//    public ResponseEntity<?> completeTodo(
//            @PathVariable
//                    long todoid,
//            @Valid
//            @RequestBody
//                Todos newTodo)
//    {
//        todosService.markComplete(todoid, newTodo);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
