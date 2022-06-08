package com.example;

import java.util.concurrent.Flow.Publisher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/publisher/todos")
public class PublisherTodoController {
	private final PublisherTodoClient todoClient;

	public PublisherTodoController(PublisherTodoClient todoClient) {
		this.todoClient = todoClient;
	}

	@GetMapping(path = "")
	public Publisher<Todo> getTodos() {
		return this.todoClient.getTodos();
	}

	@GetMapping(path = "/{id}")
	public Publisher<Todo> getTodo(@PathVariable("id") Integer id) {
		return this.todoClient.getTodo(id);
	}

	@PostMapping(path = "")
	public Publisher<Todo> postTodo(@RequestBody Todo todo) {
		return this.todoClient.postTodo(todo);
	}
}
