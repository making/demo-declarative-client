package com.example;

import java.util.concurrent.Flow.Publisher;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "/todos")
public interface PublisherTodoClient {
	@GetExchange
	Publisher<Todo> getTodos();

	@GetExchange(url = "/{id}")
	Publisher<Todo> getTodo(@PathVariable("id") Integer id);

	@PostExchange
	Publisher<Todo> postTodo(@RequestBody Todo todo);
}
