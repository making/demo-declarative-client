package com.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/async/todos")
public class AsyncTodoController {
	private final AsyncTodoClient todoClient;

	public AsyncTodoController(AsyncTodoClient todoClient) {
		this.todoClient = todoClient;
	}

	@GetMapping(path = "")
	public CompletableFuture<List<Todo>> getTodos() {
		return this.todoClient.getTodos();
	}

	@GetMapping(path = "/{id}")
	public CompletableFuture<Todo> getTodo(@PathVariable("id") Integer id) {
		return this.todoClient.getTodo(id);
	}

	@PostMapping(path = "")
	public CompletableFuture<Todo> postTodo(@RequestBody Todo todo) {
		return this.todoClient.postTodo(todo);
	}
}
