package com.qianluohan.basic;

import com.qianluohan.basic.controller.common.LoginController;
import com.qianluohan.basic.entity.Type;
import com.qianluohan.basic.service.TypeService;
import com.qianluohan.basic.utils.MyPageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {

	@Autowired
	private TypeService typeService;

	@Autowired
	private LoginController loginController;

	@Test
	public void contextLoads() {
		//List<Type> list = typeService.list(null);
		MyPageUtil<Type> list = typeService.list1();
		System.out.println(list);
	}

	@Test
	public void contextLoads1() {
		Map<String, Object> map = new HashMap<>();
		map.put("username","admin");
		map.put("password","admin");
		map.put("uuid","123456");
		map.put("captcha","8cdf4");
		loginController.login(map);
	}

}
