package com.springBoot.github.searchRepo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.github.searchRepo.dao.DaoLayer;
import com.springBoot.github.searchRepo.models.Repos;

@Service
public class RepoService {
	
	@Autowired
	DaoLayer daoLayer;
	
	List<Repos> repos = new ArrayList();

	public List<Repos> getReposByLanguage(String language) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		repos = daoLayer.getReposByLanguage(language);
		return repos;
	}

}
