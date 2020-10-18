package com.springBoot.github.searchRepo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/searchRepo")
public class HomeController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello";
	}
	
	@PostMapping("/getByLanguage")
	public List<Repos> getReposByLanguage(@RequestAttribute String language){
		return repoService.getReposByLanguage(language);
	}
	
	
}
