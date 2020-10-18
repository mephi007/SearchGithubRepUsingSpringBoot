package com.springBoot.github.searchRepo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.github.searchRepo.models.Repos;

@Service
public class RepoService {
	
	List<Repos> repos = new ArrayList();

	public List<Repos> getReposByLanguage(String language) {
		// TODO Auto-generated method stub
		repos = daoLayer.getReposByLanguage(language);
		return repos;
	}

}
