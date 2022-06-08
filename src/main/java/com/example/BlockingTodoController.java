package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/blocking/todos")
public class BlockingTodoController {
	private final BlockingTodoClient todoClient;

	public BlockingTodoController(BlockingTodoClient todoClient) {
		this.todoClient = todoClient;
	}

	@GetMapping(path = "")
	public List<Todo> getTodos() {
		return this.todoClient.getTodos();
	}

	@GetMapping(path = "/{id}")
	public Todo getTodo(@PathVariable("id") Integer id) {
		return this.todoClient.getTodo(id);
	}

	@PostMapping(path = "")
	public Todo postTodo(@RequestBody Todo todo) {
		return this.todoClient.postTodo(todo);
	}
}
