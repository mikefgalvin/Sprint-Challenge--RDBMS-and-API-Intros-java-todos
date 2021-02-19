package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService {

    //Autowired
    @Autowired
    private TodosRepository todosrepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuditing userAuditing;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        if (todosrepo.findById(todoid).isPresent()) {
            todosrepo.updateComplete(userAuditing.getCurrentAuditor().get(), todoid);
        } else {
            throw new EntityNotFoundException("Todo not found!");
        }
    }

    @Transactional
    @Override
    public Todos save(long userid, String description)
    {
        User currentUser = userService.findUserById(userid);

        Todos newtodo = new Todos(currentUser, description);

        return todosrepo.save(newtodo);
    }

}
