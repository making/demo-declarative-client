package com.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "/todos")
public interface AsyncTodoClient {
	@GetExchange
	CompletableFuture<List<Todo>> getTodos();

	@GetExchange(url = "/{id}")
	CompletableFuture<Todo> getTodo(@PathVariable("id") Integer id);

	@PostExchange
	CompletableFuture<Todo> postTodo(@RequestBody Todo todo);
}
