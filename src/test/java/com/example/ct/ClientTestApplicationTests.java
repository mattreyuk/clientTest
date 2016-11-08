package com.example.ct;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=standalone,console-logging"},webEnvironment=WebEnvironment.RANDOM_PORT)
public class ClientTestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
