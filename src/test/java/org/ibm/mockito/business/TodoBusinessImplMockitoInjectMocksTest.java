package org.ibm.mockito.business;

import org.ibm.mockito.data.api.TodoService;
import org.ibm.mockito.data.api.TodoServiceStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {
    @Mock
    TodoService todoServiceMock;
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingMock() {
        List<String> todoList= Arrays.asList("Learn Spring MVC", "Learn Mockito", "Learn Swimming In Spring");
        when(todoServiceMock.retrieveTodos("Tom")).thenReturn(todoList);
        List<String> filterdTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Tom");
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
