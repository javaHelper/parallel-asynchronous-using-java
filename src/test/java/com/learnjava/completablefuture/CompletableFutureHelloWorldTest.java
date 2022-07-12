package com.learnjava.completablefuture;

import com.learnjava.service.HelloWorldService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;
import static org.junit.jupiter.api.Assertions.*;

public class CompletableFutureHelloWorldTest {

	private HelloWorldService hws = new HelloWorldService();
	private CompletableFutureHelloWorld cfhw = new CompletableFutureHelloWorld(hws);

	@Test
	void helloWorld() {
		CompletableFuture<String> completableFuture = cfhw.helloWorld();
		completableFuture
				.thenAccept(s -> assertEquals("HELLO WORLD", s))
				.join();
	}

	@Test
	void helloWorld_1() {
		String hw = cfhw.helloWorld_1();
		assertEquals("HELLO WORLD", hw);
	}

	@Test
	void helloWorld_withSize() {
		CompletableFuture<String> completableFuture = cfhw.helloWorld_withSize();
		completableFuture
				.thenAccept(s -> {
					assertEquals("11 - HELLO WORLD", s);
				})
				.join();
	}

	@Test
	void helloWorld_multiple_async_calls() {
		String hw = cfhw.helloWorld_multiple_async_calls();
		assertEquals("HELLO WORLD!", hw);
	}

	@Test
	void helloWorld_3_async_calls() {
		String hw = cfhw.helloWorld_3_async_calls();
		assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
	}

	@Test
	void helloWorld_3_async_calls_log() {
		String hw = cfhw.helloWorld_3_async_calls_log();
		assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
	}

	@Test
	void helloWorld_3_async_calls_log_async() {
		String hw = cfhw.helloWorld_3_async_calls_log_async();
		assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
	}


	@Test
	void helloWorld_3_async_calls_custom_threadPool() {
		String hw = cfhw.helloWorld_3_async_calls_custom_threadPool();
		assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
	}

	@Test
	void helloWorld_3_async_calls_custom_threadpool_async() {
		String hw = cfhw.helloWorld_3_async_calls_custom_threadpool_async();
		assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", hw);
	}

	@Test
	void helloWorld_4_async_calls() {
		String hw = cfhw.helloWorld_4_async_calls();
		assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE! BYE!", hw);
	}

	@Test
	void helloWorld_thenCompose() {
		startTimer();
		CompletableFuture<String> completableFuture = cfhw.helloWorld_thenCompose();
		completableFuture
				.thenAccept(s -> {
					assertEquals("HELLO WORLD!", s);
				})
				.join();
		timeTaken();
	}

	@Test
	@Disabled
	void helloWorld_complete() {
		startTimer();

		CompletableFuture<String> completableFuture = cfhw.complete("hello world!");
		completableFuture
				.thenAccept(s -> {
					assertEquals("12 - HELLO WORLD!", s);
				})
				.join();
		timeTaken();
	}

	@Test
	void allOf() {
		String result = cfhw.allOf();
		assertEquals("Hello World", result);
	}

	@Test
	void anyOf() {
		String result = cfhw.anyOf();
		assertEquals("Hello World", result);
	}
}