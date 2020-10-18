package com.springBoot.github.searchRepo.dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.springBoot.github.searchRepo.models.Repos;

public class DaoLayer {
	private static String REPO_URL = "https://api.github.com/search/issues?q=language:";

	List<Repos> repos;

	public List<Repos> getReposByLanguage(String language) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		repos = new ArrayList();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(REPO_URL+language)).build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Reached DAO and hitted github api");
		return repos;
	}

}
