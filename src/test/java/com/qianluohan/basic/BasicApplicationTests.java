package com.qianluohan.basic;

import com.qianluohan.basic.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicApplicationTests {

	@Autowired
	private TypeService typeService;

	@Test
	void contextLoads() {
	}

}
