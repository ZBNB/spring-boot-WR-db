package com.example.demo.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.user.User;
import com.example.demo.service.user.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public User findById(@RequestParam(value = "id", required = true) Integer id) {
        return userService.selectByPrimaryKey(id);
    }
}
