package org.ibm.mockito.business;

import org.ibm.mockito.data.api.TodoService;
import org.ibm.mockito.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingMock() {
        TodoService mockTodoService=mock(TodoService.class);
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        when(mockTodoService.retrieveTodos("Tom")).thenReturn(todoList);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(mockTodoService);
        List<String> filterdTodos = todoBusiness.retrieveTodosRelatedToSpring("Tom");
        assertEquals(2,filterdTodos.size());
    }
    @Test
    public void testRetrieveTodosRelatedToSpring_FilteredListIsEmpty() {
        TodoService service = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(service);
        List<String> filterdTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Roy");
        assertEquals(0,filterdTodos.size());
    }
}
