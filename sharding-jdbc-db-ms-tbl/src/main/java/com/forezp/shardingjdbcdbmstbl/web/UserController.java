package com.forezp.shardingjdbcdbmstbl.web;


import com.forezp.shardingjdbcdbmstbl.entity.User;
import com.forezp.shardingjdbcdbmstbl.service.UserService;
import com.forezp.shardingjdbcdbmstbl.utils.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	private User user;

	@GetMapping("/users")
	public Object list() {
		List<User> list = userService.list();
		//Collections.sort(list);
		return list;
	}

	@GetMapping("/add")
	public Object add() {
		User user = new User();
		SnowFlake snowFlake = new SnowFlake(0,1);
		user.setId(snowFlake.nextId());
		user.setUsername("forezp");
		user.setPassword("1233edwd");
		Long resutl = userService.addUser(user);
		logger.info("insert:" + user.toString() + " result:" + resutl);
		return "ok";
	}

	@GetMapping("/delete")
	public Object delete() {
		userService.deleteAll();
		return "ok";
	}
}
