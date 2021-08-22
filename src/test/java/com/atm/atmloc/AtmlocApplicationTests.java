package com.atm.atmloc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtmlocApplicationTests {

	@InjectMocks
	AtmlocApplication atmlocApplication;
	
	@Test
	void contextLoads() {
		String[] args = {};
		assertNotNull(args);
	}

}
