package com.estudosAngular.API.Lives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ApiLivesApplication {
	@GetMapping
	public ModelAndView swaggerUi() { return new ModelAndView("redirect:/swagger-ui/");}

	public static void main(String[] args) {
		SpringApplication.run(ApiLivesApplication.class, args);
	}

}
