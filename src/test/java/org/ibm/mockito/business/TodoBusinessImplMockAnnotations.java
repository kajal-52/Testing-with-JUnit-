package org.ibm.mockito.business;

import org.ibm.mockito.data.api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;


public class TodoBusinessImplMockAnnotations {

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();
    @Mock
    TodoService todoServiceMock;
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    //Declare argument captor using annotation
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingBddMock() {

        //Given
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        given(todoServiceMock.retrieveTodos("Tom")).willReturn(todoList);
        //When
        List<String> filterdTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Tom");

        //Then
        assertThat(filterdTodos.size(),is(2));
    }
    @Test
    public void testdeleteTodosNotRelatedToSpring_UsingBddMock() {

        //Given
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        given(todoServiceMock.retrieveTodos("Tom")).willReturn(todoList);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Tom");

        //Then
//        verify(mockTodoService,times(1)).deleteTodos("Learn Mockito");
        then(todoServiceMock).should().deleteTodos("Learn Mockito");

//        verify(mockTodoService,never()).deleteTodos("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodos("Learn Spring MVC");
    }

    @Test
    public void testdeleteTodosNotRelatedToSpring_UsingBddMock_CaptureArgument() {

        //Define Argument capture on specific method call
        //Capture the argument

        //Given
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        given(todoServiceMock.retrieveTodos("Tom")).willReturn(todoList);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Tom");

        //Then
        then(todoServiceMock).should().deleteTodos(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(),is("Learn Mockito"));

    }
    @Test
    public void testdeleteTodosNotRelatedToSpring_UsingBddMock_CaptureArgumentForMultiple() {
        //Given
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming");
        given(todoServiceMock.retrieveTodos("Tom")).willReturn(todoList);

        //When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Tom");

        //Then
        then(todoServiceMock).should(times(2)).deleteTodos(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));

    }

}
