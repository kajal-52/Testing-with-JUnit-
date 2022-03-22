package org.ibm.mockito.business;

import org.ibm.mockito.data.api.TodoService;
import org.ibm.mockito.data.api.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_UsingStub() {
        TodoService service = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(service);
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
