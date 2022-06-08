package com.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/todos")
public class TodoController {
	private final TodoClient todoClient;

	public TodoController(TodoClient todoClient) {
		this.todoClient = todoClient;
	}

	@GetMapping(path = "")
	public Flux<Todo> getTodos() {
		return this.todoClient.getTodos();
	}

	@GetMapping(path = "/{id}")
	public Mono<Todo> getTodo(@PathVariable("id") Integer id) {
		return this.todoClient.getTodo(id);
	}

	@PostMapping(path = "")
	public Mono<Todo> postTodo(@RequestBody Todo todo) {
		return this.todoClient.postTodo(todo);
	}
}
