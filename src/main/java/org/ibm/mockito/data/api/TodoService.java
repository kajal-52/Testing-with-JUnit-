package org.ibm.mockito.data.api;

import java.util.List;

// External Service - Impl by another team
public interface TodoService {
	List<String> retrieveTodos(String user);
}