package com.onejava.microservices;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 1. ${user.age} -- It should be defined in properties file, else application fails
 * 2. @Value("Vivek") -- It injects hardcoded value
 * 3. @Value("${user.age}") -- It injects from properties file
 * 4. @Value("${user.name1: XXX}") -- if key doesn't exist, it injects default value(XXX) defined
 * 5. @Value("${user.list}") -- To capture comma seperated values as list of values -- user.list=Vivek,Bikash,Arvind
 * 6. @Value("#{${user.map}}") -- To capture map of values -- user.map={ID: 1112, email: 'abc@abc.com', Name: 'YYY'} -- String should be enclosed in quotes
 */

@RestController
public class HelloController {
	
	@Value("Vivek")
	private String name;
	
	@Value("${user.age}")
	private int age; 
	
	@Value("${user.name1: XXX}")
	private String name1;
	
	@Value("${user.list}")
	private List<String> users;
	
	@Value("#{${user.map}}")
	private Map<String, String> userMap;
	
	@GetMapping("/userInfo")
	public String getUserDetails() {
		return "User is: " + name + " and age is: " + age + " and name1 is: " + name1 + " and users: " + users + " and userMap: " + userMap;
	}

}
