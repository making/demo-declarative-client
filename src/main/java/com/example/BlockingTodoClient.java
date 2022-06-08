package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "/todos")
public interface BlockingTodoClient {
	@GetExchange
	List<Todo> getTodos();

	@GetExchange(url = "/{id}")
	Todo getTodo(@PathVariable("id") Integer id);

	@PostExchange
	Todo postTodo(@RequestBody Todo todo);
}
