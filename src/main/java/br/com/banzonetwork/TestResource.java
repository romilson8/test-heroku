package br.com.banzonetwork;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-h")
public class TestResource {
	
	@GetMapping
	public String hello() {
		return "Hello Heroku";
	}

}
