package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfig {
	@Bean
	public HttpServiceProxyFactory httpServiceProxyFactory(WebClient.Builder builder) {
		final WebClient webClient = builder.baseUrl("https://jsonplaceholder.typicode.com").build();
		return HttpServiceProxyFactory.builder(new WebClientAdapter(webClient)).build();
	}

	@Bean
	public TodoClient todoClient(HttpServiceProxyFactory proxyFactory) {
		return proxyFactory.createClient(TodoClient.class);
	}

	@Bean
	public BlockingTodoClient blockingTodoClient(HttpServiceProxyFactory proxyFactory) {
		return proxyFactory.createClient(BlockingTodoClient.class);
	}

	@Bean
	public AsyncTodoClient asyncTodoClient(HttpServiceProxyFactory proxyFactory) {
		return proxyFactory.createClient(AsyncTodoClient.class);
	}

	@Bean
	public PublisherTodoClient publisherTodoClient(HttpServiceProxyFactory proxyFactory) {
		return proxyFactory.createClient(PublisherTodoClient.class);
	}
}
