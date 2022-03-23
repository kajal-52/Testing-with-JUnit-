package org.ibm.mockito.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

    @Override
    public List<String> retrieveTodos(String user) {
        if(user.equals("Tom")){
            return Arrays.asList("Learn Spring MVC", "Learn Swimming","Learn Music in Spring");
        }
        else {
            return Arrays.asList();
        }
    }

    @Override
    public void deleteTodos(String todo) {

    }
}
