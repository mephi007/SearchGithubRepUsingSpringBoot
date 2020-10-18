package com.springBoot.github.searchRepo.controllers;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.github.searchRepo.models.Repos;
import com.springBoot.github.searchRepo.services.RepoService;



@RestController
@RequestMapping("/searchRepo")
public class HomeController {
	
	@Autowired
	RepoService repoService;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello";
	}
	
	@GetMapping("/getByLanguage")
	public List<Repos> getReposByLanguage(@RequestParam String language) throws IOException, InterruptedException, JSONException{
		return repoService.getReposByLanguage(language);
	}
	
	
}
