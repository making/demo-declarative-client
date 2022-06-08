package com.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "/todos")
public interface TodoClient {
	@GetExchange
	Flux<Todo> getTodos();

	@GetExchange(url = "/{id}")
	Mono<Todo> getTodo(@PathVariable("id") Integer id);

	@PostExchange
	Mono<Todo> postTodo(@RequestBody Todo todo);
}
