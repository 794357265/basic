package com.qianluohan.basic;

import com.qianluohan.basic.entity.Type;
import com.qianluohan.basic.service.TypeService;
import com.qianluohan.basic.utils.MyPageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {

	@Autowired
	private TypeService typeService;

	@Test
	public void contextLoads() {
		//List<Type> list = typeService.list(null);
		MyPageUtil<Type> list = typeService.list1();
		System.out.println(list);
	}

}
