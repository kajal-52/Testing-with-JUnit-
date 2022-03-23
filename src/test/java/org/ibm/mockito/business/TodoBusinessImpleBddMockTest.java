package org.ibm.mockito.business;

import org.ibm.mockito.data.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImpleBddMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingBddMock() {

        //Given
        TodoService mockTodoService=mock(TodoService.class);
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        given(mockTodoService.retrieveTodos("Tom")).willReturn(todoList);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(mockTodoService);

        //When
        List<String> filterdTodos = todoBusiness.retrieveTodosRelatedToSpring("Tom");

        //Then
        assertThat(filterdTodos.size(),is(2));
    }
    @Test
    public void testdeleteTodosNotRelatedToSpring_UsingBddMock() {

        //Given
        TodoService mockTodoService=mock(TodoService.class);
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        given(mockTodoService.retrieveTodos("Tom")).willReturn(todoList);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(mockTodoService);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Tom");

        //Then
        verify(mockTodoService,times(1)).deleteTodos("Learn Mockito");
        verify(mockTodoService,never()).deleteTodos("Learn Spring MVC");
    }


}
