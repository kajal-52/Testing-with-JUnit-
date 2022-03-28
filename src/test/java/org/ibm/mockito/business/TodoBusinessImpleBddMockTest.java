package org.ibm.mockito.business;

import org.ibm.mockito.data.api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
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
//        verify(mockTodoService,times(1)).deleteTodos("Learn Mockito");
        then(mockTodoService).should().deleteTodos("Learn Mockito");

//        verify(mockTodoService,never()).deleteTodos("Learn Spring MVC");
        then(mockTodoService).should(never()).deleteTodos("Learn Spring MVC");
    }

    @Test
    public void testdeleteTodosNotRelatedToSpring_UsingBddMock_CaptureArgument() {
        //Declare argument captor
        ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);

        //Define Argument capture on specific method call
        //Capture the argument


        //Given
        TodoService mockTodoService=mock(TodoService.class);
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        given(mockTodoService.retrieveTodos("Tom")).willReturn(todoList);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(mockTodoService);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Tom");

        //Then
        then(mockTodoService).should().deleteTodos(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(),is("Learn Mockito"));

    }
    @Test
    public void testdeleteTodosNotRelatedToSpring_UsingBddMock_CaptureArgumentForMultiple() {
        //Declare argument captor
        ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
        //Given
        TodoService mockTodoService=mock(TodoService.class);
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming");
        given(mockTodoService.retrieveTodos("Tom")).willReturn(todoList);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(mockTodoService);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Tom");

        //Then
        then(mockTodoService).should(times(2)).deleteTodos(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(),is(2));

    }



}
