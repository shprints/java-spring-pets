package com.example.java.spring.pets;

import com.example.java.spring.pets.concurrency.ConcurrencyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class JavaSpringPetsApplicationTests {

	@Autowired
	private ConcurrencyService service;

	@Test
	void runAsyncMethodTest() throws InterruptedException {
		assertNotEquals(1000, service.runAsyncMethod());
	}

	@Test
	void runSyncMethodTest() throws InterruptedException {
		assertEquals(1000, service.runSyncMethod());
	}

}
