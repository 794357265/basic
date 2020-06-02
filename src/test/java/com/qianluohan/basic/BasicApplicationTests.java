package com.qianluohan.basic;

import com.qianluohan.basic.entity.Item;
import com.qianluohan.basic.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.spring5.context.SpringContextUtils;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BasicApplicationTests {

	@Autowired
	private TypeService typeService;

	@Test
	void contextLoads() {
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setRemark("testwqwqdqd");
		items.add(item);
		typeService.saveItems(items);
	}

}
